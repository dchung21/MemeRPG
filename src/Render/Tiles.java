package Render;

import java.awt.*;
import Render.ImageLoader;

public class Tiles {
    public static final int tileSize = 50;
    private Image tileImage;

    public Tiles(String imagePath){
        this.tileImage = ImageLoader.loadImage(imagePath).getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
    }

    public Image getTileImage() {
        return tileImage;
    }
}
