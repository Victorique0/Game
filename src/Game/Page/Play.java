package Game.Page;
import Game.Role.EnemyList;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import Game.Role.*;
import Game.Map.*;
import java.awt.Point;

public class Play extends page implements Runnable{
    private static Play instance;
    private int number;
    private Map map;
    private EnemyList enemyList;
    private static Player player1;
    private int pos = 0;
    private String img_path = "D:/IDEA Project/Game/Picture/1.png";
    public static Play getInstance(){
        if(instance==null){
            synchronized (Play.class){
                if(instance==null){
                    instance = new Play();
                }
            }
        }
        return instance;
    }
    private Play(){
        number = 29;
        map = Map.getInstance();
        enemyList = EnemyList.getInstance();
        setBounds(0,0,1280,720);
        System.out.println(this.getInsets());
    }

    @Override
    public void run(){
        for(int i=0;i<enemyList.getSize();i++)
            new Thread(enemyList.get(i)).start();
        while(true){
            try{
                Thread.sleep(29);
            }catch(InterruptedException e){

            }
            player1.update();
        }
    }

    public void init_single(int type){
        player1 = Factory.getInstance().creatPlayer(type,3,3,40,40,40,40);
        map.init();
        while(enemyList.getSize()<number){
            Point now = map.get_free_point();
            enemyList.add((int)(now.getX()*40),(int)(now.getY()*40));
        }
        new Thread(this).start();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(player1.getImg(),player1.getX(),player1.getY(),player1.getWidth(),player1.getHeight(),this);
        for(int i=0;i<enemyList.getSize();i++){
            Enemy now = enemyList.get(i);
            g.drawImage(now.getImg(),now.x,now.y,now.width,now.height,this);
        }
    }

    @Override
    public void ResponseKeyPress(KeyEvent e){
        player1.ResponseKeyPress(e);
    }

    public void ResponseKeyRelease(KeyEvent e){
        player1.ResponseKeyRelease(e);
    }
}
