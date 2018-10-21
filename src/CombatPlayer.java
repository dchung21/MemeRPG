import java.awt.image.BufferedImage;

public class CombatPlayer {

    Meme[] myMemes;
    private BufferedImage Patrick = ImageLoader.loadImage("resources/textures/Patrick.png");

    CombatPlayer(){
        myMemes = new Meme[1];
        myMemes[0] = new Meme("Patrick", 15, Patrick);
    }

    public Meme getMyMeme(){
        return(myMemes[0]);
    }

}


