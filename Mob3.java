
public class Mob3 extends NpcAI{
	
	
	public Mob3(int xLocation, int yLocation, int height, int width, String path,int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(3);
		this.setHealth(40);
		this.setRange(40);
		this.setAttackSpeed(3);
		this.setLineOfSight(300);
		this.setDamage(25);
		this.setMode(mode);
	}
	
	public Mob3(int x, int y, int height, int width, String path, int borderX, int borderY,int mode){		
		
		this(x,y,height,width,path,mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/mob3/RightWalk.png", "src/images/mob3/LeftWalk.png", "src/images/mob3/BackWalk.png", "src/images/mob3/FrontWalk.png",
				"src/images/mob3/attack.png","src/images/mob3/attack1.png","src/images/mob3/RightWalk1.png","src/images/mob3/RightWalk2.png",
				"src/images/mob3/LeftWalk1.png","src/images/mob3/LeftWalk2.png","src/images/mob3/FrontWalk1.png","src/images/mob3/FrontWalk2.png",
				"src/images/mob3/BackWalk1.png","src/images/mob3/BackWalk2.png");
		
	}
	
	@Override
    public void run(PlayableCharacter me){
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }
}

