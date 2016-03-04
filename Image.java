/**
 * An image is something to be drawn but that will be walkable
 */

import org.jsfml.system.Vector2f;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Sprite;
import java.io.IOException;
import java.nio.file.Paths;

class Image extends Entity{

    private String pathToFile;
    private Texture imgTexture = new Texture();
    private Sprite img;
    private int height = 0;
    private int width = 0;    

    public Image(int x, int y, int height, int width, String pathToFile){
	this.height = height;
	this.width = width;
		
	//Java sets the image position relative to the centre of the image
	//This changes it to allow the position to be specified by where the top left corner will be
	x += width/2;
	y += height/2;
		
	this.pathToFile = pathToFile;
	this.loadImage();
		
	img = new Sprite(imgTexture);
	img.setOrigin(Vector2f.div(new Vector2f(imgTexture.getSize()),2));
		
	this.setX(x);
	this.setY(y);
	obj = img;
    }
    
    private void loadImage(){
	try{
	    imgTexture.loadFromFile(Paths.get(pathToFile));
	}catch (IOException ioe){
	    ioe.printStackTrace();
	}
	imgTexture.setSmooth(true);
    }

    public void setImage(String image){
	this.pathToFile = image;
	this.loadImage();
	img.setTexture(imgTexture,true);
	img.setOrigin(Vector2f.div(new Vector2f(imgTexture.getSize()),2));
	this.setX(this.getX());
	this.setY(this.getY());
	obj = img;
    }

    public int getHeight(){
	return height;
    }
    
    public int getWidth(){
	return width;
    }

    public void setHeight(int height){
	this.height = height;
    }

    public void setWidth(int width){
	this.width = width;
    }

    public void setRotation(float r){
    	img.setRotation(r);    	
    }
    
    
    @Override
    public String toString(){
	return pathToFile+" this.getX() this.getY()";
    }
}
