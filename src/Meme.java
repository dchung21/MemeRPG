import java.awt.image.BufferedImage;

public class Meme {


    private String name;
    private BufferedImage sprite;
    private int health;
    private Attack[] moves;

    Meme(String name, int health, BufferedImage sprite){

        this.moves = new Attack[1];
        moves[0] = new Attack("Star Slam", 10);
        this.name = name;
        this.health = health;
        this.sprite = sprite;

    }
    Meme(int identification){
        if(identification == 1){
            moves = new Attack[1];
            moves[0] = new Attack("Where da lamp?!", 6);
            name = "Moth";
            health = 10;
            sprite = ImageLoader.loadImage("resources/textures/Moth.png");
        }
        if(identification == 2){
            moves = new Attack[1];
            moves[0] = new Attack("NO REALLY", 1);
            name = "Nicholas Cage";
            health = 40;
            sprite = ImageLoader.loadImage("resources/textures/Nick Cage.png");
        }
        if(identification == 3){
            moves = new Attack[1];
            moves[0] = new Attack("Shoot", 14);
            name = "Drake";
            health = 3;
            sprite = ImageLoader.loadImage("resources/textures/Drake.png");
        }
    }
    public int getHealth(){
        return(health);
    }

    public Attack getAttack(int i){
        return(moves[i-1]);
    }

    public void damage(int q){
        this.health -= q;
    }

    public BufferedImage getSprite(){
        return(sprite);
    }

}
