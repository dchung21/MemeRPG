package Logic;

import Render.ImageLoader;
import Render.Map;

import java.awt.*;

public class Player {

    private int currentX, currentY;
    public static final Image player = ImageLoader.loadImage("/resources/textures/ye.jpg").getScaledInstance(50,50, Image.SCALE_SMOOTH);

    public Player(int width, int height){
        this.currentX = (width / 2) * 50;
        this.currentY = (height / 2) * 50;
    }

    public int getX(){
        return currentX;
    }

    public int getY(){
        return currentY;
    }

    public void moveForward(){
            this.currentY = this.currentY - 50;
    }

    public void moveBackward(){
            this.currentY = this.currentY + 50;
    }

    public void moveLeft(){
            this.currentX = this.currentX - 50;
        }

    public void moveRight(){
            this.currentX = this.currentX + 50;
    }

    public boolean encounter(){
        int i = this.currentX / 50;
        int j = this.currentY / 50;

        if(Map.MAP[i][j] == 0 && Map.randomEncounter()){
            return true;
        }

        else{
            return false;
        }
    }
}
