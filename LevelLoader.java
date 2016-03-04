/**
 * LevelLoader is a class factory that returns diferent instances of Levels
 */

import java.util.ArrayList;

public class LevelLoader{
    
    public LevelLoader(){
	
    }
    
    public Level loadLevel(int lvl){
	
	switch (lvl){
	case 1: return new LevelOne();
	case 2: return new LevelTwo(); //fix it
	case 3: return new LevelThree();
	default: return null;
	    
	}
	
    }
    
}


	
	



