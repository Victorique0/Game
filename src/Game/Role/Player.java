package Game.Role;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Game.Direction.*;

public class Player {
    private Rectangle rectangle;
    private Direction direction;
    private BufferedImage img;
    private BufferedImage img_up;
    private BufferedImage img_down;
    private BufferedImage img_left;
    private BufferedImage img_right;
    private int hp;
    private int speed;
    public Player(int type,int hp,int speed, int x,int y,int width,int height){
        String up = "D:/IDEA Project/Game/Picture/" + type + "-up.png";
        String left = "D:/IDEA Project/Game/Picture/" + type + "-left.png";
        String right = "D:/IDEA Project/Game/Picture/" + type + "-right.png";
        String down = "D:/IDEA Project/Game/Picture/" + type + "-down.png";
        try{
            img_up = ImageIO.read(new File(up));
            img_down = ImageIO.read(new File(down));
            img_right = ImageIO.read(new File(right));
            img_left = ImageIO.read(new File(left));

        }catch(IOException e){
            System.out.println("读取四个方向的图片出错");
        }
        direction = Direction.NONE;
        img = img_up;
        this.hp = hp;
        this.speed = speed;
        rectangle = new Rectangle(x,y,width,height);
    }

    public BufferedImage getImg(){
        return img;
    }


    public void update() {
        switch (direction) {
            case UP:
                rectangle.y -= speed;
                break;
            case DOWN:
                rectangle.y += speed;
                break;
            case LEFT:
                rectangle.x -= speed;
                break;
            case RIGHT:
                rectangle.x += speed;
                break;
        }
    }

    public int getX(){
            return rectangle.x;
        }
    public int getY(){
        return rectangle.y;
    }
    public int getWidth(){
        return rectangle.width;
    }
    public int getHeight(){
        return rectangle.height;
    }

    public void ResponseKeyRelease(KeyEvent e){
        Direction release_direction = Direction.UP;
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                release_direction = Direction.UP;
                break;
            case KeyEvent.VK_S:
                release_direction = Direction.DOWN;
                break;
            case KeyEvent.VK_A:
                release_direction = Direction.LEFT;
                break;
            case KeyEvent.VK_D:
                release_direction = Direction.RIGHT;
                break;
        }
        if(release_direction==direction)
            direction = Direction.NONE;
    }

    public void ResponseKeyPress(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                direction = Direction.UP;
                img = img_up;
                break;
            case KeyEvent.VK_S:
                direction = Direction.DOWN;
                img = img_down;
                break;
            case KeyEvent.VK_A:
                direction = Direction.LEFT;
                img = img_left;
                break;
            case KeyEvent.VK_D:
                direction = Direction.RIGHT;
                img = img_right;
                break;
        }
    }
}
