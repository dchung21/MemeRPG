import java.awt.image.BufferedImage;

public class CombatMap {

    private BufferedImage combatBg;

    CombatMap(){
        combatBg = ImageLoader.loadImage("resources/textures/PokeBG.jpg");

    }

    public BufferedImage getBg(){
        return(combatBg);
    }

}
