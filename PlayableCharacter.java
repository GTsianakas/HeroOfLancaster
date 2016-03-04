/**
 * PlayableThis class is designed for event based interaction with the player 
 * and contains all the attributes of the main this.
 */

import org.jsfml.system.Vector2f;
import org.jsfml.graphics.View;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.Keyboard;
import java.util.ArrayList;
import org.jsfml.graphics.RenderWindow;

public class PlayableCharacter extends MovableImage{

    private int health;
    private int damage;
    private int range;
    
    
    
    public PlayableCharacter(int x, int y,int height,int width, String path){
        super(x,y,height,width,path);
	this.setSpeed(4);	
	this.setHealth(1000);
	this.setDamage(10);
	this.setRange(45);
    }
    
    public int getRange(){
	return range;
    }
    
    public void setRange(int range){
	this.range = range;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
    }

    public int getDamage(){
	return damage;
    }

    public void setDamage(int damage){
	this.damage = damage;
    }

    public void getEvent(Event event, Spell es, Spell ws, Spell fs, ArrayList<NpcAI> npcs){
		
	if (event.type == Event.Type.KEY_PRESSED){
	    Keyboard key = null;

	    if (key.isKeyPressed(Keyboard.Key.D) ){
		this.setRight(true);
		setDirection(1);
	    }
					
	    if (key.isKeyPressed(Keyboard.Key.A)){
		this.setLeft(true);
		setDirection(2);
					
	    }
					
	    if (key.isKeyPressed(Keyboard.Key.W)){
		this.setUp(true);
		setDirection(3);
					
	    }
	    if (key.isKeyPressed(Keyboard.Key.S)){
		this.setDown(true);
		setDirection(4);
					
	    }
				
	    //Spells and melee attacks
		if (es.checkSpellCoolDown() && ws.checkSpellCoolDown() && fs.checkSpellCoolDown()) {
			if (key.isKeyPressed(Keyboard.Key.J) && es.checkSpellCoolDownAndCast() && ws.checkSpellCoolDown() && fs.checkSpellCoolDown()) {
			es.calculateEarthSpellPosition(this.getDirection(), this.getX(), this.getY());
			es.setSpellCasting(true);
			}

			if (key.isKeyPressed(Keyboard.Key.H) && fs.checkSpellCoolDownAndCast() && es.checkSpellCoolDown() && ws.checkSpellCoolDown()) {
			fs.calculateFireSpellPosition(this.getDirection(), this.getX(), this.getY());
			fs.setSpellCasting(true);
			}

			if (key.isKeyPressed(Keyboard.Key.K) && ws.checkSpellCoolDownAndCast() && fs.checkSpellCoolDown() && es.checkSpellCoolDown()) {
			ws.setX(this.getX());
			ws.setY(this.getY());
			ws.setSpellCasting(true);
			}
		}

	    if (key.isKeyPressed(Keyboard.Key.SPACE)){
		this.attack(npcs);
		//melee attack
	    }
		    
		   
	}

	if (event.type == Event.Type.KEY_RELEASED){
	    Keyboard key = null;
	    if (!key.isKeyPressed(Keyboard.Key.D)){
		this.setRight(false);
	    }
	    if (!key.isKeyPressed(Keyboard.Key.A)){
		this.setLeft(false);
	    }
	    if (!key.isKeyPressed(Keyboard.Key.W)){
		this.setUp(false);
	    }
	    if (!key.isKeyPressed(Keyboard.Key.S)){
		this.setDown(false);
	    }
	    this.correctDirection("src/images/me/meRightWalk.png","src/images/me/meLeftWalk.png","src/images/me/meBackWalk.png","src/images/me/meFrontWalk.png");	    
	}
    }

    

    public void walk(RenderWindow r,View v){
	if (this.getRight()){
			
	    animation("src/images/me/meRightWalk1.png","src/images/me/meRightWalk2.png");
	    this.moveRight();
	    if(getX()>v.getCenter().x+50)
		vRight(r,v);
	}
		
	if (this.getUp()){
			
	    animation("src/images/me/meBackWalk1.png","src/images/me/meBackWalk2.png");
	    this.moveUp();
	    if(getY()<v.getCenter().y-50)
		vUp(r,v);
	}
		
	if (this.getLeft()){
			
	    animation("src/images/me/meLeftWalk1.png","src/images/me/meLeftWalk2.png");
	    this.moveLeft();
	    if(getX()<v.getCenter().x-50)
		vLeft(r,v);
	}
		
	if(this.getDown()){
			
	    animation("src/images/me/meFrontWalk1.png","src/images/me/meFrontWalk2.png");
	    this.moveDown();
	    if(getY()>v.getCenter().y+50)
		vDown(r,v);
	}
    }
    
    public void vRight(RenderWindow r,View v){
    	v.setCenter(new Vector2f(v.getCenter().x+4,v.getCenter().y));
    	r.setView(v);
    }
    
    public void vLeft(RenderWindow r,View v){
    	v.setCenter(new Vector2f(v.getCenter().x-4,v.getCenter().y));
    	r.setView(v);	
    }
    public void vUp(RenderWindow r,View v){
    	v.setCenter(new Vector2f(v.getCenter().x,v.getCenter().y-4));
    	r.setView(v);
    }
    public void vDown(RenderWindow r,View v){
    	v.setCenter(new Vector2f(v.getCenter().x,v.getCenter().y+4));
    	r.setView(v);
    }
    
    
    public void playerCollision(ArrayList<? extends CollidableImage> terrain){
	for (CollidableImage t : terrain){
	    if (this.within(t)){
		if (this.getX() + 0.5 * this.getWidth() < t.getX()){ //Then we know right hand side of this has hit left of t
		    if (this.getRight() && !this.toString().equals("npc")){
			this.setX(this.getX()-(this.getSpeed()+1));
		    }
		    this.setRight(false);
				    
		}
				
		if (this.getX() - 0.5 * this.getWidth() > t.getX()){ //Then we know left hand side of this has hit right of t
		    if (this.getLeft() && !this.toString().equals("npc")){
			this.setX(this.getX()+(this.getSpeed()+1));
		    }
		    this.setLeft(false);
		
				    
		}
				
		if (this.getY() + 0.5 * this.getHeight() > t.getY()){ //Then we know up hand side of this has hit bottom of t
		    if (this.getUp() && !this.toString().equals("npc")){
			this.setY(this.getY()+(this.getSpeed()+1));
		    }
		    this.setUp(false);
				   
		}
				
		if (this.getY() - 0.5 * this.getHeight() < t.getY()){ //Then we know down hand side of this has hit top of  t
		    if (this.getDown() && !this.toString().equals("npc")){
			this.setY(this.getY()-(this.getSpeed()+1));
		    }
		    this.setDown(false);
		
		} 
	    }
	}
    }
    
    public void attack(ArrayList<NpcAI> npcs){

	for(NpcAI npc : npcs){
	    switch (getDirection()){
	    case 1: { //right
			
		if (this.getDistance(npc) <= this.getRange() && this.getX() < npc.getX()){
		    npc.setHealth(npc.getHealth() - this.getDamage());
		}
		this.setImage("src/images/me/meAttackRight.png");
		break;
	    }
			    
	    case 2:{ //left
		if (this.getDistance(npc) <= this.getRange() && this.getX() > npc.getX()){
		    npc.setHealth(npc.getHealth() - this.getDamage());
		}
				
		this.setImage("src/images/me/meAttackLeft.png");
		break;
	    }
			    
	    case 3:{ //back
		if (this.getDistance(npc) <= this.getRange() && this.getY() > npc.getY()){
		    npc.setHealth(npc.getHealth() - this.getDamage());
		}
		this.setImage("src/images/me/meAttackBack.png");
		break;
	    }
			    
	    case 4:{ //front
		if (this.getDistance(npc) <= this.getRange() && this.getY() < npc.getY()){
		    npc.setHealth(npc.getHealth() - this.getDamage());
		}
		this.setImage("src/images/me/meAttackFront.png");
		break;
	    }
			
	    }
	    
	}
    }
    
    /*
     * non diano
     public void walk(RenderWindow r,View v){
     if (this.getRight() ){
			
     animation("src/images/me/meRightWalk1.png","src/images/me/meRightWalk2.png");
     this.moveRight();
     if(getX()>v.getCenter().x+200)
     vRight(r,v);
     }
		
     else if (this.getUp() ){
			
     animation("src/images/me/meBackWalk1.png","src/images/me/meBackWalk2.png");
     this.moveUp();
     if(getY()<v.getCenter().y-200)
     vUp(r,v);
     }
		
     else if (this.getLeft() ){
			
     animation("src/images/me/meLeftWalk1.png","src/images/me/meLeftWalk2.png");
     this.moveLeft();
     if(getX()<v.getCenter().x-200)
     vLeft(r,v);
     }
		
     else if(this.getDown() ){
			
     animation("src/images/me/meFrontWalk1.png","src/images/me/meFrontWalk2.png");
     this.moveDown();
     if(getY()>v.getCenter().y+200)
     vDown(r,v);
     }
     } 
    */
    
}
