package Game.Role;

import java.util.Vector;

public class EnemyList {
    private static EnemyList instance;
    private Vector<Enemy> enemy_list;
    private EnemyList(){
        enemy_list = new Vector<Enemy>();
    }
    public static EnemyList getInstance(){
        if(instance == null){
            synchronized (EnemyList.class){
                if(instance==null){
                    instance = new EnemyList();
                }
            }
        }
        return instance;
    }

    public void add(int x,int y){
        enemy_list.add(new Enemy(x,y));
    }

    public Enemy get(int index){
        return enemy_list.get(index);
    }

    public int getSize(){
        return enemy_list.size();
    }
}
