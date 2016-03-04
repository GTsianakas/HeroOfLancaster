
public class Mob1 extends NpcAI{
	
	
	public Mob1(int xLocation, int yLocation, int height, int width, String path,int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(2);
		this.setHealth(30);
		this.setRange(40);
		this.setAttackSpeed(3);
		this.setLineOfSight(300);
		this.setDamage(25);
		this.setMode(mode);
	}
	
	public Mob1(int x, int y, int height, int width, String path, int borderX, int borderY,int mode){		
		
		this(x,y,height,width,path,mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/mob1/RightWalk.png", "src/images/mob1/LeftWalk.png", "src/images/mob1/BackWalk.png", "src/images/mob1/FrontWalk.png",
				"src/images/mob1/attack.png","src/images/mob1/attack1.png","src/images/mob1/RightWalk1.png","src/images/mob1/RightWalk2.png",
				"src/images/mob1/LeftWalk1.png","src/images/mob1/LeftWalk2.png","src/images/mob1/FrontWalk1.png","src/images/mob1/FrontWalk2.png",
				"src/images/mob1/BackWalk1.png","src/images/mob1/BackWalk2.png");
		
	}
	
	@Override
    public void run(PlayableCharacter me){
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }
}

