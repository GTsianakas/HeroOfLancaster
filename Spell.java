/**
 * Created by Michael Jackson on 02/02/2016.
 */

import org.jsfml.graphics.*;


/**
 * Still needs:
 * -Damage for all spells
 * -Circular collision detection
 */

public class Spell extends CollidableImage
{
    private int spellTime = 20;
    private int spellTimeCounter = 0;
    private boolean spellCasting = false;
    private long lastTimeCast = 0;
    private int coolDownTime = 4;   //In seconds
    private double damage = 1;
    private int earthSpellOffSet = 200;


    public Spell(int x, int y,int height,int width, String path)
    {
        super(x,y,height,width,path);
    }

    /**
     * Method to determine whether a spell is currently casting, or whether it has terminated.
     * @return True if the spell is casting, false if the spell is not casting
     */
    public boolean stillCasting()
    {
        if (spellTimeCounter < spellTime){
            spellTimeCounter++;
            return true;
        }
        else {
            spellTimeCounter = 0;
            spellCasting = false;
            return false;
        }
    }

    /**
     * Method to determine whether enough time has passed for the spell to be cast again
     * and updates the last time the spell was cast
     * @return True if the spell may be cast again, false if more time needs to pass.
     */
    public boolean checkSpellCoolDown()
    {
        if ((System.currentTimeMillis() - lastTimeCast) >= (coolDownTime * 1000)){
            return true;
        }
        return false;
    }

    /**
     * Method to determine whether enough time has passed for the spell to be cast again
     * and updates the last time the spell was cast
     * @return True if the spell may be cast again, false if more time needs to pass.
     */
    public boolean checkSpellCoolDownAndCast()
    {
        if ((System.currentTimeMillis() - lastTimeCast) >= (coolDownTime * 1000)){
            lastTimeCast = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    /**
     * Method to set the image position for the earth spell when cast
     * @param characterDirection Current direction the playable character is facing
     * @param charXPos Current XPosition of the playable character
     * @param charYPos Current YPosition of the playable character
     */
    public void calculateEarthSpellPosition(int characterDirection, int charXPos, int charYPos)
    {
        if (characterDirection == 1){
            this.setX(charXPos + this.getEarthSpellOffSet());
            this.setY(charYPos);
        }
        else if (characterDirection == 2){
            this.setX(charXPos - this.getEarthSpellOffSet());
            this.setY(charYPos);
        }
        else if (characterDirection == 3){
            this.setY(charYPos - this.getEarthSpellOffSet());
            this.setX(charXPos);
        }
        else if (characterDirection == 4) {
            this.setY(charYPos + this.getEarthSpellOffSet());
            this.setX(charXPos);
        }
    }

    /**
     * Method to set the image position for the fire spell when cast
     * @param characterDirection Current direction the playable character is facing
     * @param charXPos Current XPosition of the playable character
     * @param charYPos Current YPosition of the playable character
     */
    public void calculateFireSpellPosition(int characterDirection, int charXPos, int charYPos)
    {
        if (characterDirection == 1){ //right
            this.setRotation(0);
            if (this.getWidth() < this.getHeight()) {
                int originalWidth = this.getWidth();
                this.setWidth(this.getHeight());
                this.setHeight(originalWidth);
            }
            this.setX(charXPos + (int)(0.5 * this.getWidth()));
            this.setY(charYPos);
        }
        else if (characterDirection == 2){ //left
            this.setRotation(0);
            if (this.getWidth() < this.getHeight()) {
                int originalWidth = this.getWidth();
                this.setWidth(this.getHeight());
                this.setHeight(originalWidth);
            }
            this.setX(charXPos -(int)(0.5 * this.getWidth()));
            this.setY(charYPos);
        }
        else if (characterDirection == 3){ //up
            this.setRotation(90);
            if (this.getWidth() > this.getHeight()) {
                int originalWidth = this.getWidth();
                this.setWidth(this.getHeight());
                this.setHeight(originalWidth);
            }
            this.setY(charYPos - (int)(0.5 * this.getHeight()));
            this.setX(charXPos);
        }
        else if (characterDirection == 4) { //down
            this.setRotation(90);
            if (this.getWidth() > this.getHeight()) {
                int originalWidth = this.getWidth();
                this.setWidth(this.getHeight());
                this.setHeight(originalWidth);
            }
            this.setY(charYPos + (int)(0.5 *this.getHeight()));
            this.setX(charXPos);
        }
    }

    //Accessors and set methods

    public int getSpellTime() {
        return spellTime;
    }

    public void setSpellTime(int spellTime) {
        this.spellTime = spellTime;
    }

    public boolean isSpellCasting() {
        return spellCasting;
    }

    public void setSpellCasting(boolean spellCasting) {
        this.spellCasting = spellCasting;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getEarthSpellOffSet() {
        return earthSpellOffSet;
    }

    public void setEarthSpellOffSet(int earthSpellOffSet) {
        this.earthSpellOffSet = earthSpellOffSet;
    }
    
    public void getCoolDown(){
    	
    }
}
