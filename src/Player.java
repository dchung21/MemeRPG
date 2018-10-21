import java.awt.*;

public class Player {

    private int currentX, currentY;
    public static final Image player = ImageLoader.loadImage("/resources/textures/ye.jpg");

    Player(int width, int height){
        this.currentX = (width / 2) * 32;
        this.currentY = (height / 2) * 32;
    }

    public int getX(){
        return currentX;
    }

    public int getY(){
        return currentY;
    }

    public void moveForward(){
            this.currentY = this.currentY - 32;
    }

    public void moveBackward(){
            this.currentY = this.currentY + 32;
    }

    public void moveLeft(){
            this.currentX = this.currentX - 32;
        }

    public void moveRight(){
            this.currentX = this.currentX + 32;
    }

}
