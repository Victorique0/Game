package Game.Role;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Game.Direction.*;
public class Enemy extends Rectangle implements Runnable {
    private BufferedImage img;
    private Direction direction;
    private int speed;
    private int set_direction;
    public Enemy(int x,int y) {
        set_direction = 29;
        direction = Direction.NONE;
        speed = 3;
        this.x = x;
        this.y = y;
        width = 40;
        height = 40;
        try {
            img = ImageIO.read(new File("D:/IDEA Project/Game/Picture/5.png"));
        } catch (IOException e) {
            System.out.println("Enemy类读取图片失败");
        }
    }
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(29);
            }catch (InterruptedException e){
                System.out.println("Enemy刷新出错");
            }
            update();
            if(set_direction==29){
                get_direction();
                set_direction = 0;
            }else {
                set_direction += 1;
            }
        }
    }

    public BufferedImage getImg(){
        return img;
    }

    private void get_direction(){
        double num = Math.random()*10;
        if(num<2.5)
            direction = Direction.UP;
        else if(num<5)
            direction = Direction.DOWN;
        else if(num<7.5)
            direction = Direction.LEFT;
        else
            direction = Direction.RIGHT;
    }

    private void update(){
        switch (direction){
            case NONE:
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
    }
}
