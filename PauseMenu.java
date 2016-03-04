import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.jsfml.graphics.View;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

public class PauseMenu{

    private RenderWindow window;
    private View view;
    private ArrayList<Button> Buttons = new ArrayList<Button>();
    private Image bg = new Image(0,0,768,1024,"src/images/menus/pause.jpg");
    

    public PauseMenu(RenderWindow window, View v){
	this.window = window;
	this.view = v;
	init();
    }
    
    public void init(){
	view.setCenter(new Vector2f(512,384));
	window.setView(view);
	Buttons.add(new Button(500, 200,"Resume", Color.BLACK));
	   
	//Buttons.add(new Button(500, 350,"Restart level", Color.BLACK));
	   
	Buttons.add(new Button(500, 500,"Back to Main Menu", Color.BLACK));
	    
	    
	//adding font
	Font sansRegular = new Font();
	try {
	    sansRegular.loadFromFile(Paths.get("src/fonts/Barbarian.ttf"));
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }
	
    public int run(){
	int output = 0;
	
	while (output == 0){
	    
	    bg.draw(window);
            bg.move();          
	    
            for (Entity t : Buttons){
                t.draw(window);
                t.move();             
            }
            
	    // Loops through checking assigned keys for any user input
    	    for (Event event : window.pollEvents()) {
		for (Button t : Buttons){
			    
		    if(Buttons.get(Buttons.indexOf(t)).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){
			Buttons.get(Buttons.indexOf(t)).getButton().setColor(Color.RED);
			if(Mouse.isButtonPressed(Mouse.Button.LEFT)){
			    //Resume game
			    if (Buttons.get(0).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){ 
				System.out.println("Resume Game");
				output = 1;	
			    }
			    
			    //Return to main menu
			    if (Buttons.get(1).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){ 
				System.out.println("Returning to main menu");
				output = 2;
			    }
	    			    
			}
	    										
		    }
		    else
			Buttons.get(Buttons.indexOf(t)).getButton().setColor(Color.BLACK);
		}
		if (event.type == Event.Type.CLOSED) {
		    output = -1;
		}
	    		
    	    }
	    window.display();
	}
	
	
	return output;
    }
    
}
