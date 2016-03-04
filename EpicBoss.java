import org.jsfml.graphics.Text;

public class EpicBoss extends NpcAI{
	
	
	    public EpicBoss(int xLocation, int yLocation, int height, int width, String path, int mode){
			super(xLocation,yLocation,height,width,path,mode);
			this.setSpeed(3);
			this.setHealth(200);
			this.setRange(40);
			this.setAttackSpeed(5);
			this.setLineOfSight(300);
			this.setDamage(35);
			this.title(new Text( ("Ragnarok"),this.getFont(),15) );
			this.setMode(mode);			
	    }
	    
	    public EpicBoss(int x, int y, int height, int width, String path, int borderX, int borderY, int mode){
			this(x,y,height,width,path,mode);
			this.setBorderX(borderX);
			this.setBorderY(borderY);
			this.setImages("src/images/3/rw.png", "src/images/3/lw.png", "src/images/3/bw.png", "src/images/3/fw.png",
					"src/images/3/whirwind.png","src/images/3/spell.png","src/images/3/rw1.png","src/images/3/rw2.png",
					"src/images/3/lw1.png","src/images/3/lw2.png","src/images/3/fw1.png","src/images/3/fw2.png",
					"src/images/3/bw1.png","src/images/3/bw2.png");
	    }
	    @Override
	    public void run(PlayableCharacter me){
	    	this.updateTitle(35,70);
	    	this.AI(this.getBorderX(),this.getBorderY(),this.getMode(),me);
	    }
}
