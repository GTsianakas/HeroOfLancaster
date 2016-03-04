/*
 * This class is an example class of how a mob will be created. you add the stats and the sprites and then 
 * you give him the AI that you want that can be customized accordingly
 */
public class Mob4 extends NpcAI{

   public Mob4(int xLocation, int yLocation, int height, int width, String path,int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(1);
		this.setHealth(50);
		this.setRange(40);
		this.setAttackSpeed(2);
		this.setLineOfSight(500);
		this.setDamage(25);
		this.setMode(mode);
	}
	
	public Mob4(int x, int y, int height, int width, String path, int borderX, int borderY,int mode){		
		
		this(x,y,height,width,path,mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/Mob4/RightWalk.png", "src/images/Mob4/LeftWalk.png", "src/images/Mob4/BackWalk.png", "src/images/Mob4/FrontWalk.png",
				"src/images/Mob4/attack.png","src/images/Mob4/attack1.png","src/images/Mob4/RightWalk1.png","src/images/Mob4/RightWalk2.png",
				"src/images/Mob4/LeftWalk1.png","src/images/Mob4/LeftWalk2.png","src/images/Mob4/FrontWalk1.png","src/images/Mob4/FrontWalk2.png",
				"src/images/Mob4/BackWalk1.png","src/images/Mob4/BackWalk2.png");
		
	}
	
	@Override
    public void run(PlayableCharacter me){
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }

}
