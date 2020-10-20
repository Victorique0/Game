package Game.Role;

import Game.Page.Play;

public class Factory {
    private static Factory instance;
    private Factory(){}
    public static Factory getInstance(){
        if(instance==null){
            synchronized (Factory.class){
                if(instance==null){
                    instance = new Factory();
                }
            }
        }
        return instance;
    }

    public Player creatPlayer(int type,int hp,int speed, int x,int y,int width,int height){
        return new Player(type,hp,speed,x,y,width,height);
    }
}
