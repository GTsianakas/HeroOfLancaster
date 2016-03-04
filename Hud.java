
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.RenderStates;
import org.jsfml.system.*;

public class Hud{
	
	private static int fontSize  = 20;
	private PlayableCharacter me = null;
	
	private Font sansRegular = new Font();
	
    private Text healthString; 
    private Text coolDown;
    private float cd = 4;
	
    private Image heart = new Image(9, 11, 50, 50, "src/images/HUD/heart.png");
	private Image redBar = new Image(30, 11, 50, 50, "src/images/HUD/cantSpell.png");
	private Image greenBar = new Image(30, 11, 50, 50, "src/images/HUD/canSpell.png");		
	

	private Clock clock = new Clock();
	
	public Hud(PlayableCharacter me){
		
	try{
	    sansRegular.loadFromFile(Paths.get("src/fonts/LucidaSansRegular.ttf"));
	}catch (IOException ex) {
	    ex.printStackTrace();
	}
		this.me = me;
		healthString = new Text (Integer.toString(me.getHealth()), sansRegular, fontSize); 
		healthString.setPosition(heart.getX(), heart.getY());
		healthString.setStyle(Text.BOLD);
		healthString.setColor(Color.WHITE);

		coolDown = new Text("ha",sansRegular,25);
		coolDown.setPosition(me.getX()+300, me.getY()-200);
		coolDown.setColor(Color.CYAN);
		coolDown.setStyle(Text.BOLD);
	}
	
	public void updateCD(){
		if(cd - clock.getElapsedTime().asSeconds() >= 0){
			coolDown.setString( Integer.toString((int)(cd - clock.getElapsedTime().asSeconds())) );
			coolDown.setPosition(redBar.getX()-10, redBar.getY()-25);
		}
	}
	
	public void updateHealth(PlayableCharacter me){
		healthString.setString(Integer.toString(me.getHealth()));
		healthString.setPosition(heart.getX()-20, heart.getY()-15);
	}
	
	public void setPos(int x, int y){
		heart.setCoords(x+110,y);
		redBar.setCoords(x,y);
		greenBar.setCoords(x,y);
	}
	
	public void drawGreenHud(RenderWindow window){
		heart.draw(window);
		greenBar.draw(window);
	}
	
	public void drawRedHud(RenderWindow window){
		heart.draw(window);
		redBar.draw(window);
		healthString.setPosition(heart.getX(),heart.getY());
	}
	
	public void drawCD(RenderWindow window){
		coolDown.draw(window, RenderStates.DEFAULT);
	}
	
	public void  restartClock(){
		clock.restart();
	}
	
	public void moveGreen(){
		heart.move();
		greenBar.move();
	}
	
	public void moveRed(){
		heart.move();
		redBar.move();
		
	}

	public void drawText(RenderWindow win){
		healthString.draw(win, RenderStates.DEFAULT);
	}
	
	

}
