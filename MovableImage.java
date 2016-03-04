import org.jsfml.system.Clock;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;

public abstract class MovableImage extends CollidableImage{
    
    
    private int speed;
    
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    
    private String spriteRight;
    private String spriteLeft;
    private String spriteUp;
    private String spriteDown;

    //animation
    private  Clock clock = new Clock();
    private double delayTime = 0.2;
    private int direction;

    
    public MovableImage(int x, int y,int height,int width, String path){
	super(x,y,height,width,path);
    }
    
    public int getSpeed(){
	return speed;
    }
    
    public void setSpeed(int speed){
	this.speed = speed;
    }
    
    public void setSpriteRight(String path){
	this.spriteRight = path;
    }
    
    public void setSpriteLeft(String path){
	this.spriteLeft = path;
    }

    public void setSpriteUp(String path){
	this.spriteUp = path;
    }

    public void setSpriteDown(String path){
	this.spriteDown = path;
    }
    
    //replace with image sprites
    public void moveRight(){
	this.setX(this.getX()+this.getSpeed());
	
    }
		
    public void moveLeft(){
	this.setX(this.getX()-this.getSpeed());
	
    }

    public void moveDown(){
	this.setY(this.getY()+this.getSpeed());
		
	
    }
		
    public void moveUp(){
	this.setY(this.getY()-this.getSpeed());
		
    }
    
    public boolean getUp(){
        return up;
    }
    public boolean getDown(){
        return down;
    }
    public boolean getLeft(){
        return left;
    }
    public boolean getRight(){
        return right;
    }

    public void setUp(boolean u){
        up = u;
    }

    public void setDown(boolean d){
        down = d;
    }

    public void setLeft(boolean l){
        left = l;
    }

    public void setRight(boolean r){
        right = r;
    }

    public void animation(String s1, String s2){
		if(clock.getElapsedTime().asSeconds() <= delayTime)
		    this.setImage(s1);
		
		if(clock.getElapsedTime().asSeconds() >= delayTime){
		    this.setImage(s2);
		    
		    if(clock.getElapsedTime().asSeconds() >= 0.4)
			clock.restart();				
		}
    }
    
    public void meCenter(RenderWindow r,View v){
    	v.setCenter(this.getX(),this.getY());
    	r.setView(v);
    	
    }
    
    public void  correctDirection(String s1,String s2,String s3,String s4){
		switch(getDirection()){
			case 1: this.setImage(s1);break;
			case 2: this.setImage(s2);break;
			case 3: this.setImage(s3);break;
			case 4: this.setImage(s4);break;
		}
    }
    
    public void setDirection(int i){
    	this.direction = i;
    }
    
    public int getDirection(){
    	return direction;
    }

}
