/**
 * Created by Michael on 18/02/2016.
 */
public class HealthPickUp extends CollidableImage {

    private int healthIncreaseValue = 100;

    public HealthPickUp (int x, int y,int height,int width, String path){
        super(x,y,height,width,path);
    }

    /**
     * Method invokes the health increase effect of health pickup
     * @param character The playable character to have it's health increased
     */
    public void effect(PlayableCharacter character) {
        character.setHealth(character.getHealth() + healthIncreaseValue);
    }
}
