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
            this.currentY = this.currentY - Tiles.tileSize;
    }

    public void moveBackward(){
            this.currentY = this.currentY + Tiles.tileSize;
    }

    public void moveLeft(){
            this.currentX = this.currentX - Tiles.tileSize;
        }

    public void moveRight(){
            this.currentX = this.currentX + Tiles.tileSize;
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
