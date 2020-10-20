package Game.Listener;
import Game.EventSend.EventSend;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private static Keyboard instance;
    private Keyboard(){}
    public static Keyboard getInstance(){
        if(instance==null){
            synchronized (Keyboard.class){
                if(instance==null){
                    instance = new Keyboard();
                }
            }
        }
        return instance;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        EventSend.getInstance().Keyboard_event_press(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        EventSend.getInstance().Keyboard_event_release(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
