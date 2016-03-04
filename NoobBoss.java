import org.jsfml.graphics.*;
public class NoobBoss extends NpcAI{
		
    public NoobBoss(int xLocation, int yLocation, int height, int width, String path,int mode){
		super(xLocation,yLocation,height,width,path,mode);
		this.setSpeed(3);
		this.setHealth(250);
		this.setRange(40);
		this.setAttackSpeed(2);
		this.setLineOfSight(300);
		this.setDamage(25);	
		this.title(new Text( ("Noob Caster"),this.getFont(),15) );
		this.setMode(mode);
    }
    
    public NoobBoss(int x, int y, int height, int width, String path, int borderX, int borderY,int mode){
		this(x,y,height,width,path,mode);
		this.setBorderX(borderX);
		this.setBorderY(borderY);
		this.setImages("src/images/2/2rw.png", "src/images/2/2lw.png", "src/images/2/2bw.png", "src/images/2/2fw.png",
				"src/images/2/2rw.png","src/images/2/2spell.png","src/images/2/2rw1.png","src/images/2/2rw2.png",
				"src/images/2/2lw1.png","src/images/2/2lw2.png","src/images/2/2fw1.png","src/images/2/2fw2.png",
				"src/images/2/2bw1.png","src/images/2/2bw2.png");
    }
	@Override
    public void run(PlayableCharacter me){
		this.updateTitle(40,50);
    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
    }
}
