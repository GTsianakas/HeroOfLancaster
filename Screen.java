/**
 * Screen class; creates a frame to display the game.
 */

import org.jsfml.window.event.Event;
import org.jsfml.window.Window;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.graphics.RenderWindow;

public class Screen{

    private RenderWindow window = new RenderWindow();
    
    private int screenWidth  = 1024;
    private int screenHeight = 768;
    private String title = "Welcome!";
    
    public Screen(){}
    
    public Screen(int screenWidth,int screenHeight, String title){
	this.screenHeight = screenHeight;
	this.screenWidth = screenWidth;
	this.title = title;
    }	
    
    public void init(){
	window.create(new VideoMode(screenWidth,screenHeight),title,WindowStyle.DEFAULT);
	window.setFramerateLimit(60);
	window.display();
    }
    
    public RenderWindow getWindow(){
	return window;
    }

    public int getScreenHeigh(){
	return screenHeight;
    }

    public int getScreenWidth(){
	return screenWidth;
    }
    
    public String getTitle(){
    	return title;
    }
    
    public void setTitle(String title){
    	this.title = title;
    }

}
