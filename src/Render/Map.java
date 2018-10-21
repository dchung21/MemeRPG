package Render;

import java.awt.*;

public class Map {

    private static final int MAP_SIZE = 100;
    public static int[][] MAP = new int[MAP_SIZE][MAP_SIZE];
    public static final Image grass = ImageLoader.loadImage("/resources/textures/grass.png").getScaledInstance(Tiles.tileSize,Tiles.tileSize, Image.SCALE_SMOOTH);
    public static final Image tallGrass = ImageLoader.loadImage("/resources/textures/tallGrass.png").getScaledInstance(Tiles.tileSize,Tiles.tileSize, Image.SCALE_SMOOTH);

    Map(){
        generateMap();
    }

    private void generateMap(){
        for(int i = 0; i < MAP.length; i++){
            for(int j = 0; j < MAP.length; j++){
                if(Math.random() > 0.98){
                    MAP[i][j] = 0;
                }

                else{
                    MAP[i][j] = 1;
                }
            }
        }
    }

    public int getMapSize(){
        return MAP_SIZE;
    }

    public static boolean randomEncounter(){
        if(Math.random() > 0.6){
            return true;
        }

        return false;
    }
}
