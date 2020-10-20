package Game.Page;
import Game.EventSend.EventSend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Choose extends page {
    private Vector<BufferedImage> img_list;
    private int player1_index;
    private int player2_index;
    private String state;
    private JButton Choose_jb_start_game;
    private static Choose instance;
    public static Choose getInstance(){
        if(instance==null){
            synchronized (Choose.class){
                if(instance==null){
                    instance = new Choose();
                }
            }
        }
        return instance;
    }
    private Choose(){
        setLayout(null);
        setBounds(0,0,1280,720);
        img_list = new Vector<BufferedImage>();
        for(int i=0;i<3;i++){
            String path = "D:/IDEA Project/Game/Picture/" + i + ".PNG";
            try{
                img_list.add(ImageIO.read(new File(path)));
            }catch(IOException e){}
        }
        Choose_jb_start_game = new JButton("开始游戏");
        Choose_jb_start_game.setBounds(590,600,100,50);
        Choose_jb_start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventSend.getInstance().Choose_start_button(state,player1_index,player2_index);
            }
        });
        player1_index = 0;
        player2_index = 0;


        add(Choose_jb_start_game,new Integer(200));
    }

    public void init_single(){
        player1_index = 0;
        state = "single";
    }

    public void init_double(){
        player1_index = 0;
        player2_index = 0;
        state = "double";
    }

    @Override
    public void ResponseKeyPress(KeyEvent e){
        if(state.equals("single"))
            change_role_single(e);
        else
            change_role_double(e);
    }
    @Override
    public void ResponseKeyRelease(KeyEvent e){
    }

    private void change_role_single(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                player1_index = (player1_index+2)%3;
                break;
            case KeyEvent.VK_D:
                player1_index = (player1_index+1)%3;
                break;
        }
    }

    private void change_role_double(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                player1_index = (player1_index+2)%3;
                break;
            case KeyEvent.VK_D:
                player1_index = (player1_index+1)%3;
                break;
            case KeyEvent.VK_LEFT:
                player2_index = (player2_index+2)%3;
                break;
            case KeyEvent.VK_RIGHT:
                player2_index = (player2_index+1)%3;
                break;
        }
    }


    public void paint(Graphics g){
        super.paint(g);
        if(state.equals("single")){
            g.drawImage(img_list.get(player1_index),565,300,150,150,this);
        }else{
            g.drawImage(img_list.get(player1_index),300,300,150,150,this);
            g.drawImage(img_list.get(player2_index),830,300,150,150,this);
        }
    }

}
