
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Color;

public class Button extends Entity{
	
    private static int fontSize     = 40;
    private static String fontPath  = "src/fonts/LucidaSansRegular.ttf";
    private Text button;
    
    public Button(int xLocation,int yLocation,String option, Color c){
		
	/*
	 * Load the font
	 */
	Font sansRegular = new Font();
	try {
	    sansRegular.loadFromFile(Paths.get(fontPath));
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	    
	Text text = new Text (option, sansRegular, fontSize);
	text.setColor(c);
	text.setStyle(Text.BOLD);
	    
	FloatRect textBounds = text.getLocalBounds();
	    
	// Find middle and set as origin/ reference point
	text.setOrigin(textBounds.width / 2,textBounds.height / 2);
	setX(xLocation);
	setY(yLocation);
	    
	obj = text;
	button = text;
    }

    public Text getButton(){
	return button;
    }
	
}
