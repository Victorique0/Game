package Game.EventSend;
import Game.Page.Choose;
import Game.Page.Play;
import Game.Page.Window;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class EventSend {
    private static EventSend instance;
    private EventSend(){}
    public static EventSend getInstance(){
        if(instance==null){
            synchronized (EventSend.class){
                if(instance==null){
                    instance = new EventSend();
                }
            }
        }
        return instance;
    }
    public void Start_single(){
        Choose.getInstance().init_single();
        Window.getInstance().change_to_Choose();
    }
    public void Start_double(){
        Choose.getInstance().init_double();
        Window.getInstance().change_to_Choose();
    }
    public void Keyboard_event_press(KeyEvent e){
        Window.getInstance().getJp().ResponseKeyPress(e);
    }
    public void Keyboard_event_release(KeyEvent e){
        Window.getInstance().getJp().ResponseKeyRelease(e);
    }
    public void Choose_start_button(String state,int type1, int type2){
        if(state.equals("single")){
            Play.getInstance().init_single(type1);
            Window.getInstance().change_to_Play_single();
        }
    }
}
