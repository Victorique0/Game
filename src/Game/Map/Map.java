package Game.Map;
import java.awt.Point;
public class Map {
    private static Map instance;
    private int[][] map;
    private Map(){
        map = new int[32][18];
        for(int i=0;i<32;i++) {
            for (int j = 0; j < 18; j++)
                map[i][j] = 0;
        }
    }
    public static Map getInstance(){
        if(instance==null){
            synchronized (Map.class){
                if(instance==null){
                    instance = new Map();
                }
            }
        }
        return instance;
    }

    public Point get_free_point(){
        int free_x = 0;
        int free_y = 0;
        do{
            free_x = (int)(Math.random()*32);
            free_y = (int)(Math.random()*18);
        }
        while(map[free_x][free_y]==1);
        map[free_x][free_y] = 1;
        System.out.println("(" + free_x + "," + free_y + ")");
        return new Point(free_x,free_y);
    }

    public void init(){

        for(int i=0;i<32;i++){
            for(int j=0;j<18;j++)
                map[i][j] = 0;
        }
    }
}
