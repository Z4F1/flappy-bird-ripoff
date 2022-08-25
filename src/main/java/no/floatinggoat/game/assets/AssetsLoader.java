package no.floatinggoat.game.assets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class AssetsLoader  {
    private static List<Texture> textures = new ArrayList<>();
    private static List<CustomFont> fonts = new ArrayList<>();

    /**
     * For loading textures and it is then stored in AssetsLoader.
     * It can then be retrieved anywhere in the project by using {@link AssetsLoader#getTexture} and its {@code name} parameter.
     * 
     * @param name                      The name to store it after in AssetsLoader.
     * @param fileName                  The actual file name in the textures folder in the resources folder.
     * @throws FontFormatException
     * @throws IOException
     */

    public static void loadTexture(String name, String path) throws IOException  {
        System.out.println(String.format(" - Loading texture %s from path %s:", name, path));

        try (InputStream inputStream = AssetsLoader.class.getResourceAsStream("/texture/" + path)) {
            BufferedImage image = ImageIO.read(inputStream);
            Texture temp = new Texture(name, image);
    
            textures.add(temp);
    
            System.out.println(String.format(" + Loaded texture %s from path %s \n", name, path));
        }
    }

    /**
     * For loading fonts and it is then stored in AssetsLoader.
     * It can then be retrieved anywhere in the project by using {@link AssetsLoader#getFont} and its {@code name} parameter.
     * 
     * @param name                      The name to store it after in AssetsLoader.
     * @param path                  The actual file name in the font folder in the resources folder.
     * @throws FontFormatException
     * @throws IOException
     */
    public static void loadFont(String name, String path) throws IOException, FontFormatException{
        System.out.println(String.format(" - Loading font %s from path %s:", name, path));

        try (InputStream inputStream = AssetsLoader.class.getResourceAsStream("/font/" + path)) {
            Font font = Font.createFont(Font.PLAIN, inputStream);
            CustomFont temp = new CustomFont(name, font);

            fonts.add(temp);

            System.out.println(String.format(" + Loaded font %s from path %s: \n", name, path));
        }
    }

    /**
     * Is used to retrieve the loaded texture by its name. 
     * 
     * @param name                      The name the texture is stored by.
     * @return                          The texture asset
     * @throws NoSuchElementException   is thrown when there is nothing stored by the name.
     */
    public static Texture getTexture(String name) throws NoSuchElementException {
        for (Texture texture : textures) {
            if (name.equals(texture.getName())) return texture;
        }

        throw new NoSuchElementException(String.format("Could not find texture with name %s", name));
    }

    /**
     * Is used to retrieve the loaded font by its name. 
     * 
     * @param name                      The name the font is stored by.
     * @return                          The font asset
     * @throws NoSuchElementException   is thrown when there is nothing stored by the name.
     */
    public static CustomFont getFont(String name) throws NoSuchElementException {
        for (CustomFont font : fonts) {
            if (name.equals(font.getName())) return font;
        }

        throw new NoSuchElementException(String.format("Could not find font with name %s", name));
    }
}
