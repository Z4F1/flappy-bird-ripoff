package no.floatinggoat.game.assets;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public interface Asset<E> {
    /**
     * Method for getting the name of the Asset.
     * 
     * @return the name of the asset.
     */
    public String getName();

    /**
     * Method for getting the actual asset.
     * 
     * @return the asset with the original file type it is needed in.
     */
    public E getAsset();
}
