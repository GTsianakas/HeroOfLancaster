import org.jsfml.graphics.Text;

public class MeleeBoss extends NpcAI{

    public MeleeBoss(int xLocation, int yLocation, int height, int width, String path, int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(3);
		this.setHealth(200);
		this.setRange(40);
		this.setAttackSpeed(4);
		this.setLineOfSight(300);
		this.setDamage(25);
		this.title(new Text( ("Big Lubber"),this.getFont(),15) );
		this.setMode(mode);
    }
    
    public MeleeBoss(int x, int y, int height, int width, String path, int borderX, int borderY, int mode){
		this(x,y,height,width,path, mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/1/1RightWalk.png", "src/images/1/1LeftWalk.png", "src/images/1/1BackWalk.png", "src/images/1/1FrontWalk.png",
				"src/images/1/whirwind.png","src/images/1/ha.png","src/images/1/1RightWalk1.png","src/images/1/1RightWalk2.png",
				"src/images/1/1LeftWalk1.png","src/images/1/1LeftWalk2.png","src/images/1/1FrontWalk1.png","src/images/1/1FrontWalk2.png",
				"src/images/1/1BackWalk1.png","src/images/1/1BackWalk2.png");
    }
        
    @Override
    public void run(PlayableCharacter me){
    	this.updateTitle(40,100);
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }
}
