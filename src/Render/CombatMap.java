package Render;

import Render.ImageLoader;

import java.awt.image.BufferedImage;
import Logic.CombatPlayer;
import Logic.Meme;
//Creates the map and area for calculations during combat
public class CombatMap {

    private BufferedImage combatBg;
    private CombatPlayer combatP;
    private Meme enemy;


    public CombatMap(){
        combatBg = ImageLoader.loadImage("/resources/textures/PokeBG.jpg");
        combatP = new CombatPlayer();
        enemy = new Meme((int)(Math.random()*3+1));
    }

    //getter functions for background sprite, combat player, and enemy meme
    public BufferedImage getBg(){
        return(combatBg);
    }

    public CombatPlayer getCp(){
        return(combatP);
    }

    public Meme getEnemy(){
        return(enemy);
    }
}
