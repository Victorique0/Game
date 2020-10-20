package Game.Page;
import Game.EventSend.EventSend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Start extends page{
    private JButton jb_single;
    private JButton jb_double;
    private JLabel img;
    private static Start instance;
    public static Start getInstance(){
        if(instance==null){
            synchronized (Start.class){
                if(instance==null){
                    instance = new Start();
                }
            }
        }
        return instance;
    }

    private Start(){
        this.setLayout(null);
        this.setBounds(0,0,1280,720);
        img = new JLabel(new ImageIcon("D:/IDEA Project/Game/Picture/2.jpg"));
        img.setBounds(0,0,1280,720);
        jb_single = new JButton("单人游戏");
        jb_single.setBounds(490,600,100,50);
        jb_single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventSend.getInstance().Start_single();
            }
        });
        jb_double = new JButton("双人游戏");
        jb_double.setBounds(690,600,100,50);
        jb_double.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventSend.getInstance().Start_double();
            }
        });

        this.add(img,new Integer(100));
        this.add(jb_single,new Integer(200));
        this.add(jb_double,new Integer(200));
    }

    @Override
    public void ResponseKeyPress(KeyEvent e) {

    }
    @Override
    public void ResponseKeyRelease(KeyEvent e){
    }
}
