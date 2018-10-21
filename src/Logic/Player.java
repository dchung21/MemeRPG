package Logic;

import Render.ImageLoader;
import Render.Map;
import Render.Tiles;

import java.awt.*;

public class Player {

    private int currentX, currentY;
    public static final Image player = ImageLoader.loadImage("/resources/textures/ye.jpg").getScaledInstance(Tiles.tileSize,Tiles.tileSize, Image.SCALE_SMOOTH);

    public Player(int width, int height){
        this.currentX = 500;
        this.currentY = 500;
    }

    public int getX(){
        return currentX;
    }

    public int getY(){
        return currentY;
    }

    public void moveForward(){
                Map.shift(-1, 0);
    }

    public void moveBackward(){
        Map.shift(1, 0);;
    }

    public void moveLeft(){
            Map.shift(0, -1);
        }

    public void moveRight(){
            Map.shift(0, 1);
    }

    public boolean encounter(){
        int i = this.currentX / Tiles.tileSize;
        int j = this.currentY / Tiles.tileSize;

        if(Map.MAP[i][j] == 0 && Map.randomEncounter()){
            return true;
        }

        else{
            return false;
        }
    }
}
