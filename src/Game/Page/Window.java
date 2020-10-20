package Game.Page;
import Game.Listener.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Window instance;
    private page jp;
    private Window(){
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBounds(screen_width/2-640,screen_height/2-360,1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        addKeyListener(Keyboard.getInstance());
        jp = Start.getInstance();
        add(jp);

        setFocusable(true);//获取焦点 JFrame 、JComponent、JLabel默认是不可以获得焦点
        setVisible(true);
    }
    public static Window getInstance(){
        if(instance==null){
            synchronized (Window.class){
                if(instance==null){
                    instance = new Window();
                }
            }
        }
        return instance;
    }

    public page getJp(){
        return jp;
    }

    public void change_to_Choose(){
        this.remove(jp);
        this.jp = Choose.getInstance();
        this.add(jp);
    }

    public void change_to_Play_single(){
        remove(jp);
        jp = Play.getInstance();
        add(jp);
        //窗口变化才会显示出Play的内容
        //找不到解决办法 只能强制变化窗口
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        //System.out.println(screen_width);
        //System.out.println(screen_height);
        //System.out.println(this.getInsets());
        setBounds(0,0,screen_width,screen_height);
        setBounds(screen_width/2-640,screen_height/2-360,1280,720);
    }
}
