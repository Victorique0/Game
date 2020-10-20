package Game.Main;

import Game.Page.Window;

public class main {
    public static void main(String[] args) throws InterruptedException{
        Window window = Window.getInstance();
        while(true){
            window.repaint();
            Thread.sleep(29);
        }
    }
}
