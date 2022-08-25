package no.floatinggoat.game.assets;

import java.awt.image.BufferedImage;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Texture implements Asset<BufferedImage> {
    private String name;
    private BufferedImage image;

    /**
     * @param name      The name of the image to be stored.
     * @param image     The actual image.
     */
    public Texture(String name, BufferedImage image){
        this.name = name;
        this.image = image;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public BufferedImage getAsset(){
        return image;
    }
}
