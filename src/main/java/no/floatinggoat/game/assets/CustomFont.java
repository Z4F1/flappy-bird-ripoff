package no.floatinggoat.game.assets;

import java.awt.Font;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class CustomFont implements Asset<Font> {
    private String name;
    private Font font;

    /**
     * @param name  The name of the font to be stored by.
     * @param font  The actual font.
     */
    public CustomFont(String name, Font font){
        this.name = name;
        this.font = font;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Font getAsset() {
        return this.font;
    }
    
}
