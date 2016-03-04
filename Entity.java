/**
 * Entity class is the root class of every drawable object on the screen
 * can set the coordinants and draws the object.
 */

import org.jsfml.graphics.Transformable;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Drawable;

abstract class Entity{

    Transformable obj; //jsfml object that implements Drawable
    
    private int x;
    private int y;
    private RenderWindow w;

    /**
     * Used to draw Drawable objects on a RenderWindow
     * @param w the RenderWindow to be drawn on
     */
    
    public void draw(RenderWindow w){
        w.draw((Drawable)obj);
        this.w = w;
    }
    
    public RenderWindow getWindow(){
    	return w;
    }
    
    /**
     * sets the x position of the object
     * @param x the coordinant of the object on the x-axis
     */

    public void setX(int x){
        this.x = x;
    }

    /**
     * sets the y position of the object
     * @param y the coordinant of the object on the y-axis
     */

    public void setY(int y){
        this.y = y;
    }

    /**
     * sets the x and y position of the object
     * @param x the coordinant of the object on the x-axis
     * @param y the coordinant of the object on the y-axis
     */

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * gets the x position of the object
     * @return int the coordinant of the object on the x-axis
     */

    public int getX(){
        return x;
    }

    /**
     * gets the y position of the object
     * @return int the coordinant of the object on the y-axis
     */

    public int getY(){
        return y;
    }

    /**
     * moves the object to its pre-defined position
     */

    public void move(){
        obj.setPosition(x,y);
    }


}
