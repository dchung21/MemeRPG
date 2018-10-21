import java.awt.*;

public class Map {

    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private static int[][] MAP = new int[WIDTH][HEIGHT];
    public static final Image grass = ImageLoader.loadImage("/resources/textures/grass.png");
    public static final Image tallGrass = ImageLoader.loadImage("/resources/textures/tallGrass.png");

    Map(){
        generateMap();
    }

    private void generateMap(){
        for(int i = 0; i < MAP.length; i++){
            for(int j = 0; j < MAP.length; j++){
                if(Math.random() > 0.7){
                    MAP[i][j] = 0;
                }

                else{
                    MAP[i][j] = 1;
                }
            }
        }
    }

    public int[][] getMap(){
        return this.MAP;
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }


}
