package no.floatinggoat.flappy.model.factory.pillar;

import no.floatinggoat.flappy.model.factory.Factory;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.transform.Transform;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class BothPillarFactory extends Factory{

    private int score = 0;

    public BothPillarFactory() {
        super(new BothPillar(0), 3, 1000, 250);
    }

    @Override
    public void update(Scene scene){
        super.update(scene);

        Transform playerTransform = scene.getPlayer().getTransform();
        int pillarSize = getDefaultItem().getWidth();

        // For calculating the score:
        // This looks confusing, but actually makes sense
        // This is for calculating the score which is based on the players position.
        // It is then calculated based on when the pillars or pipes start and divided by the width of the pillars and gap between
        // this will then calculate the score.
        score = (int) ((playerTransform.getPosition().x - getStartPos() + (pillarSize + getGap())) / (pillarSize + getGap()));

        // Just to make sure it never is below 0.
        if (score < 0) score = 0;
    }

    /**
     * Method for getting the score.
     * 
     * @return The score.
     */
    public int getScore(){
        return score;
    }
}
