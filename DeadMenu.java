import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;
import org.jsfml.graphics.View;

public class DeadMenu {
	
    private RenderWindow window;
    private ArrayList<Button> Buttons = new ArrayList<Button>();
	private String imagePath;
	private String msg ="";
    private Image bg;
    private Text deadMessage;
    private View view;
	
	
    public DeadMenu(RenderWindow window, View v, String path, String msg){
	this.window = window;
	this.view = v;
	this.imagePath = path;
	this.msg = msg;
	bg = new Image(0,0,768,1024,imagePath);
	init();
    }
	
	public DeadMenu(RenderWindow window, View v){
	this.window = window;
	this.view = v;
	this.imagePath =  "src/images/menus/dead.jpg";
	bg = new Image(0,0,768,1024,imagePath);
	
	msg = "You Are Dead";
	init();
    }
	
	
    public void init(){
	view.setCenter(new Vector2f(512,384));
	window.setView(view);
	Buttons.add(new Button(500, 640,"Back to Main Menu", Color.BLACK));
        
        //adding font
    	Font sansRegular = new Font();
    	try {
    	    sansRegular.loadFromFile(Paths.get("src/fonts/LucidaSansRegular.ttf"));
    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	}
    	
    	deadMessage = new Text(msg,sansRegular,70);
    	deadMessage.setStyle(Text.BOLD);
        deadMessage.setPosition(280, 100);
        deadMessage.setColor(Color.RED);
    	
    }
	
    public int run() {
	int output = 0;
		
	while (output == 0){
			
	    bg.draw(window);
            bg.move();
            deadMessage.draw(window, RenderStates.DEFAULT);
           
            for (Entity t : Buttons){
                t.draw(window);
                t.move();             
            }		
		
	    // Loops through checking assigned keys for any user input
	    for (Event event : window.pollEvents()) {
		for (Button t : Buttons){
	    		    
		    if(Buttons.get(Buttons.indexOf(t)).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){
			Buttons.get(Buttons.indexOf(t)).getButton().setColor(Color.WHITE);
			if(Mouse.isButtonPressed(Mouse.Button.LEFT)){
			    //Back to Main Menu
			    if (Buttons.get(0).getButton().getGlobalBounds().contains( new Vector2f(Mouse.getPosition(window)))){ 
				output = 1;
				System.out.println("back to main");
	        			
			    }		 
			}
	    										
		    }
		    else
			Buttons.get(Buttons.indexOf(t)).getButton().setColor(Color.RED);
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
