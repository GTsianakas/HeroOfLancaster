import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;

public class MainMenu{
	
    private RenderWindow window;
    private ArrayList<Button> Buttons = new ArrayList<Button>();
    private Image bg = new Image(0,0,768,1024,"src/images/menus/main.jpg");
    private Text gameName;
    private View view;

    public MainMenu(RenderWindow window, View v){
     	this.window = window;
	this.view = v;
	this.init();
    }
	
    public void init(){
	
	view.setCenter(new Vector2f(512,384));
	window.setView(view);
        Buttons.add(new Button(500, 200,"New Game", Color.BLACK));
        Buttons.add(new Button(500, 300,"Continue Game", Color.BLACK));
		Buttons.add(new Button(500, 400,"Survival Mode", Color.BLACK));
		Buttons.add(new Button(500, 600,"Exit Game", Color.BLACK));
        Buttons.add(new Button(500, 500,"Instructions", Color.BLACK));
	// Buttons.add(new Button(700, 500,"Mute Sound", Color.BLACK));
		
	//adding font
	Font sansRegular = new Font( );
	try {
	    sansRegular.loadFromFile(Paths.get("src/fonts/Barbarian.ttf"));
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
		
	gameName = new Text("The Hero of Lancaster",sansRegular,60);
        gameName.setStyle(Text.BOLD);
        gameName.setPosition(95, 50);
        gameName.setColor(Color.BLACK);
    }
	
    public int run(){

	
	int output = 0;
		
	while (output == 0){
	    bg.draw(window);
            bg.move();
            gameName.draw(window, RenderStates.DEFAULT);
           
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
			    //new game
			    if (Buttons.get(0).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){ 
				System.out.println("New Game!!");
				output = 1;	
			    }
			    
			    if (Buttons.get(1).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){ 
				output = 2;
				System.out.println("loading level");
			    }

				//Survival Mode
				if (Buttons.get(2).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){
					output = 4;
					System.out.println("Loading survival mode");
				}
			    //exit game
			    if (Buttons.get(3).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){
				output = -1;
				System.out.println("exiting from menu");
			    }

			    if (Buttons.get(4).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){
				output = 3;
				System.out.println("instructions");
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

	}//while

	return output;
	
    }//run

}
