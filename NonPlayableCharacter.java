import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.*;

public abstract class NonPlayableCharacter extends MovableImage{
	
    private double health;
    private int range;
    private int attackSpeed;
    private int lineOfSight;
    private int damage;
    private Font sansRegular = new Font();
    private Text title;
    
	
    public NonPlayableCharacter(int xLocation, int yLocation,int height,int width, String path){
	super(xLocation,yLocation,height,width,path);
	
    }
    
    public void setAttackSpeed(int attackSpeed){
	this.attackSpeed = attackSpeed;
    }
    
    public int getAttackSpeed(){
	return attackSpeed;
    }

    public int getDamage(){
	return damage;
    }

    public void setDamage(int damage){
	this.damage = damage;
    }
    
    public void setLineOfSight(int lineOfSight){
	this.lineOfSight = lineOfSight;
    }

    public void setRange(int range){
	this.range = range;
    }

    public int getRange(){
	return range;
    }

    public int getLineOfSight(){
	return lineOfSight;
    }
    
   
    public double getHealth(){
	return health;
    }
	
    public void setHealth(double health){
	this.health = health;
    }
	
    
    public void title(Text t){
    	try {
	    sansRegular.loadFromFile(Paths.get("src/fonts/FrizQuadrataFont.otf"));
	} catch (IOException ex) {ex.printStackTrace();}
    	this.title = t;
    	this.title.setColor(Color.MAGENTA);
    	this.title.setStyle(Text.BOLD);
    }
    
    public Font getFont(){
    	return sansRegular;
    }
    
    public void updateTitle(float f1, float f2){
    	this.title.setPosition(this.getX()-f1, this.getY()-f2);
    	this.title.draw(this.getWindow(), RenderStates.DEFAULT);
    }
    
}
