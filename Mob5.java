
public class Mob5 extends NpcAI{
	
	
	public Mob5(int xLocation, int yLocation, int height, int width, String path,int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(3);
		this.setHealth(40);
		this.setRange(40);
		this.setAttackSpeed(3);
		this.setLineOfSight(300);
		this.setDamage(25);
		this.setMode(mode);
	}
	
	public Mob5(int x, int y, int height, int width, String path, int borderX, int borderY,int mode){		
		
		this(x,y,height,width,path,mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/mob5/RightWalk.png", "src/images/mob5/LeftWalk.png", "src/images/mob5/BackWalk.png", "src/images/mob5/FrontWalk.png",
				"src/images/mob5/attack.png","src/images/mob5/attack1.png","src/images/mob5/RightWalk1.png","src/images/mob5/RightWalk2.png",
				"src/images/mob5/LeftWalk1.png","src/images/mob5/LeftWalk2.png","src/images/mob5/FrontWalk1.png","src/images/mob5/FrontWalk2.png",
				"src/images/mob5/BackWalk1.png","src/images/mob5/BackWalk2.png");
		
	}
	
	@Override
    public void run(PlayableCharacter me){
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }
}

