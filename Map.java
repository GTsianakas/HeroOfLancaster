/**
 * class Map contains all the non-movable Entitys of a level.
 */

import java.util.ArrayList;

public class Map{
	
    Image background;
    ArrayList<CollidableImage> terrain = new ArrayList<CollidableImage>();
	
	
    public void addBackground(Image image){
	background = image;
    }
    
    public void addTerrain(CollidableImage img){
	terrain.add(img);
    }

	
    public Image getBackground(){
	return background;
    }
    
    public ArrayList<CollidableImage> getTerrain(){
	return terrain;
    }
        
	
}
