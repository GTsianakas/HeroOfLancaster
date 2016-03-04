import org.jsfml.graphics.*;
import org.jsfml.graphics.ConvexShape;
import org.jsfml.system.Clock;
import org.jsfml.system.*;

import java.util.ArrayList;

public abstract class NpcAI extends NonPlayableCharacter{

    private Clock clock = new Clock();
    private Clock patrolClock = new Clock();    
    
    private int borderX;
    private int borderY;
    private long lastTime = 0;
    private double delayTime = 1;
    private int mode;
    
    //for correcting direction
    private String s1,s2,s3,s4;// direction
    private String s5,s6;//attack 
    private String s7,s8,s9,s10,s11,s12,s13,s14;//movement
    
    private int randomDirection,randomSpell;
    
    private Spell ws = new Spell(0, 0, 96, 96, "src/images/spell/water.png");
    private Spell es = new Spell(0, 0, 96, 96, "src/images/spell/earth.png");
    private Spell fs = new Spell(0, 0, 400, 22, "src/images/spell/fire.png");
 
    public NpcAI(int xLocation, int yLocation,int height,int width, String path,int mode){
	super(xLocation,yLocation,height,width,path);
    }
    
    public long getLastTime(){
    	return lastTime;
    }
    
    public void setLastTime(long lastTime){
    	this.lastTime = lastTime;
    }
    
    public int getBorderX(){
    	return borderX;
    }

    public int getBorderY(){
    	return borderY;
    }

    public void setBorderX(int borderX){
    	this.borderX = borderX; 
    }

    public void setBorderY(int borderY){
    	this.borderY = borderY;
    }
   
    public void setImages(String s1, String s2, String s3, String s4, String s5, String s6,String s7, String s8, String s9, 
			  String s10,String s11, String s12, String s13, String s14){
    	this.s1 = s1;
    	this.s2 = s2;
    	this.s3 = s3;
    	this.s4 = s4;
    	this.s5 = s5;
    	this.s6 = s6;
    	this.s7 = s7;
    	this.s8 = s8;
    	this.s9 = s9;
    	this.s10 = s10;
    	this.s11 = s11;
    	this.s12 = s12;
    	this.s13 = s13;
    	this.s14 = s14;    
    }
    
    public void AI(int borderX, int borderY, int mode, PlayableCharacter me){
    	if(mode ==1){//melee boss & melee mobs    	    	
    		
		    if(this.getDistance(me) < this.getLineOfSight()){
				this.setSpeed(Math.abs(this.getSpeed()));
				this.chase(me);
		    } 
		    if (this.getDistance(me) <= this.getRange()){
		    	this.attack(me,1);
		    }
				
		    if(this.getDistance(me) > this.getLineOfSight()){
		    	this.correctDirection(s1,s2,s3,s4);
		    }
	}    	
    	
    	if(mode == 2){//noobBoss	
		    if(this.getDistance(me) < this.getLineOfSight()){
	    			
			this.attack(me,2);    			
		    }
		    if(this.getDistance(me) > this.getLineOfSight()){
			nonMovement(me);  
			this.correctDirection(s1,s2,s3,s4);
		    }
    	}
    	
    	if(mode == 3){//final boss
		    if(this.getDistance(me) < this.getLineOfSight()){
			this.setSpeed(Math.abs(this.getSpeed()));
			this.chase(me);
			this.attack(me,3);    			
		    }
	    		
		    if(this.getDistance(me) > this.getLineOfSight()){
			this.correctDirection(s1,s2,s3,s4);
		    }
    	}
    	
    	if(mode == 4){//patrol left-right
    		if(this.getDistance(me) <= this.getRange())
    			this.attack(me,1);    		
    		else
    			this.patrol(1);
    		
    	}
    	
    	if(mode == 5){//patrol up-down
    		if(this.getDistance(me) <= this.getRange())
    			this.attack(me,1);    		
    		else
    			this.patrol(2);
    	}
    }

    public void attack(PlayableCharacter me, int mode){   
    	animation(s5,s6);
    	if(mode == 1){	    	    	
	    meleeAttack(me);
    	}
    	
    	if(mode == 2){//cast spells
	    spellAttack(me);
    	}
    	
    	if(mode == 3){
	    //melee attack
	    if(this.getDistance(me) > this.getLineOfSight()){	
		meleeAttack(me);
	    }
	    //cast spell
	    spellAttack(me);
    	}
    }
    public void meleeAttack(PlayableCharacter me){
	if ((System.currentTimeMillis() - lastTime) >= (this.getAttackSpeed()*1000)){
	    me.setHealth(me.getHealth()-this.getDamage());
	    lastTime = System.currentTimeMillis();
	}
    }
	
    public void spellAttack(PlayableCharacter me){
	if(clock.getElapsedTime().asSeconds()-0.4 >= 0){
	    randomDirection = (int)(1+Math.random()*(4-1+1));
	    randomSpell = (int)(1+Math.random()*(3-1+1));
    		
	    if(randomSpell == 1)//fire
		spellCast(randomSpell, me);	    			
	    else if(randomSpell == 2)//earth
		spellCast(randomSpell, me);						    						
	    else if(randomSpell == 3)//water
		spellCast(randomSpell, me);					
	    clock.restart();
	}
    }

    public void spellCast(int randomSpell, PlayableCharacter me){
    	if(randomSpell == 1){
	    fs.calculateFireSpellPosition(randomDirection, this.getX(), this.getY());
	    fs.move();
	    fs.draw(this.getWindow());
			
	    if(fs.within(me)){
		me.setHealth(me.getHealth() - 25);//damage
		System.out.println("me hit by fire spell");
	    }
	}

    	else if(randomSpell == 2){
	    es.calculateEarthSpellPosition(randomDirection, this.getX(), this.getY());
	    es.move();
	    es.draw(this.getWindow());	
			
	    if(es.within(me)){
		me.setHealth(me.getHealth() - 25);//damage
		System.out.println("me hit by earth spell");
	    }
	}

    	else if(randomSpell == 3){
	    ws.setX(this.getX());
	    ws.setY(this.getY());
	    ws.move();
	    ws.draw(this.getWindow());		
			
	    if(ws.within(me)){
		me.setHealth(me.getHealth() - 25);//damage
		System.out.println("me hit by water spell");
	    }
	}
    }

    
    //just standing
    public void nonMovement(PlayableCharacter me){
    	if (me.getX() >= this.getX())
	    this.setDirection(1);	
    	else if (me.getX() <= this.getX())
	    this.setDirection(2);		
    	else if (me.getY() >= this.getY())
	    this.setDirection(4);	
	else if (me.getY() <= this.getY())
	    this.setDirection(3);
    }
    
    
    public void chase(PlayableCharacter me){
	
    	if(this.getDistance(me) > this.getRange()){
	    
    		if (me.getY() < this.getY()){
				if (getUp()){
				    animation(s13,s14);
				    this.moveUp();
				    this.setDirection(3);
				}
		    }
    		
		    if (me.getX() > this.getX()){
				if (getRight()){	
				    animation(s7,s8);
				    this.moveRight();
				    this.setDirection(1);
				}
		    }
		    		    		    
		    if (me.getY() > this.getY()){
				if (getDown()){
				    animation(s11,s12);
				    this.moveDown();
				    this.setDirection(4);
				}
		    } 
		    
		    if (me.getX() < this.getX()){
				if (getLeft()){
				    animation(s9,s10);
				    this.moveLeft();
				    this.setDirection(2);
				}						
		    }
		    			
    	}
    }
    
    public void collisionAI(ArrayList<CollidableImage> terrain, ArrayList<NpcAI> npc){
	this.terrainCollision(terrain);
	this.npcCollision(npc);
    }
    public void npcCollision(ArrayList<NpcAI> npc){
	//talk to each other or what ever
	//this.terrainCollision(npc);
	
	for (NpcAI t : npc){
	    if (this.within(t) && !this.equals(t)){
		if (this.getX() + 0.5 * this.getWidth() < t.getX()){ //Then we know right hand side of this has hit left of t
		    if (this.getRight() && this.toString().equals("npc")){
			this.setX(this.getX()-(this.getSpeed()+1));
		    }
		    this.setRight(false);
		    
		}
		
		if (this.getX() - 0.5 * this.getWidth() > t.getX()){ //Then we know left hand side of this has hit right of t
		    if (this.getLeft() && this.toString().equals("npc")){
			this.setX(this.getX()+(this.getSpeed()+1));
		    }
		    this.setLeft(false);
		
				    
		}
				
		if (this.getY() + 0.5 * this.getHeight() > t.getY()){ //Then we know up hand side of this has hit bottom of t
		    if (this.getUp() && this.toString().equals("npc")){
			this.setY(this.getY()+(this.getSpeed()+1));
		    }
		    this.setUp(false);
				   
		}
				
		if (this.getY() - 0.5 * this.getHeight() < t.getY()){ //Then we know down hand side of this has hit top of  t
		    if (this.getDown() && this.toString().equals("npc")){
			this.setY(this.getY()-(this.getSpeed()+1));
		    }
		    this.setDown(false);
		
		} 
	    }
	}

    }

    private void checkWithin(CollidableImage terrain){


    }

    public void terrainCollision(ArrayList<? extends CollidableImage> terrain){

	boolean flag = true;
	for (CollidableImage t : terrain){
	    if (this.within(t)){
		
		//if (this.toString().equals("npc") && this.equals(t)){
		//  continue;
		//}

		flag = false;
	    
		if (this.getX() + 0.5 * this.getWidth() < t.getX()){ //Then we know right hand side of this has hit left of t
		    this.setRight(false);
		} else{
		    this.setRight(true);
		}
		
		if (this.getX() - 0.5 * this.getWidth() > t.getX()){ //Then we know left hand side of this has hit right of t
		    this.setLeft(false);
		} else{
		    this.setLeft(true);
		}
		
		if (this.getY() + 0.5 * this.getHeight() > t.getY()){ //Then we know up hand side of this has hit bottom of t
		    this.setUp(false);
		} else{
		    this.setUp(true);
		}
		
		if (this.getY() - 0.5 * this.getHeight() < t.getY()){ //Then we know down hand side of this has hit top of  t
		    this.setDown(false);
		}  else{
		    this.setDown(true);
		}
	    }//within   
	    else{
		if (flag){
		    this.setDown(true);
		    this.setUp(true);
		    this.setLeft(true);
		    this.setRight(true);
		}
	    }
	}	
	
    }

    public void patrol(int mode){
    	  
	    	  if(mode==1){
		    	  
		    	  if(this.getX() >= 300 || this.getX() <= -200){
		    		  this.setSpeed(-this.getSpeed());
		    	  if(this.getSpeed() > 0)
		    		  animation("src/images/mob1/leftWalk1.png","src/images/mob1/leftWalk2.png");
		    	  else
		    		  animation("src/images/mob1/rightWalk1.png","src/images/mob1/rightWalk2.png");
			      this.setX(this.getSpeed()+this.getX());
		    	  }
	    	  }
    					
	    	  if(mode==2){
		    	  
		    	  if(this.getY() >= this.getY()+this.getBorderX() || this.getY() <= this.getY()+this.getBorderY()){
		    		  this.setSpeed(-this.getSpeed());
			      if(this.getSpeed() > 0)
			    	  animation("src/images/mob1/FrontWalk1.png","src/images/mob1/FrontWalk2.png");
			      else
			    	  animation("src/images/mob1/BackWalk1.png","src/images/mob1/BackWalk2.png");
			      this.setY(this.getSpeed()+this.getY());
		    	  }
	    	  }
	    	  patrolClock.restart();
	    	  

    }
    
    public void setMode(int mode){
    	this.mode = mode;
    }
    
    public int getMode(){
    	return mode;
    }
    
    @Override
    public String toString(){
	return "npc";
    }
    
    public abstract void run(PlayableCharacter me); //need to Override 

}
/*
  public void triangleInitiate(int x){
  triangle.setPoint(0, new Vector2f(this.getX(),this.getY()));
  if(x==0){
  triangle.setPoint(1, new Vector2f(this.getX()-getLineOfSight(),this.getY()+getLineOfSight()));
  triangle.setPoint(2, new Vector2f(this.getX()+getLineOfSight(),this.getY()+getLineOfSight()));
		
  }
	
  if(x==1){        	
  triangle.setPoint(1, new Vector2f(this.getX()-getLineOfSight(),this.getY()+getLineOfSight()));
  triangle.setPoint(2, new Vector2f(this.getX()-getLineOfSight(),this.getY()-getLineOfSight()));
		
  }
	
  if(x==2){        	
  triangle.setPoint(1, new Vector2f(this.getX()-getLineOfSight(),this.getY()-getLineOfSight()));
  triangle.setPoint(2, new Vector2f(this.getX()+getLineOfSight(),this.getY()-getLineOfSight()));
		
  }
	
  if(x==3){        	
  triangle.setPoint(1, new Vector2f(this.getX()+getLineOfSight(),this.getY()-getLineOfSight()));
  triangle.setPoint(2, new Vector2f(this.getX()+getLineOfSight(),this.getY()+getLineOfSight()));
		
  }    	 
  }
  //sometimes causes trouble when entering chase mode
  public void patrol(int borderX, int borderY, int mode, PlayableCharacter me){
  double delayTime = 0.001;


  if(clock.getElapsedTime().asSeconds() >= delayTime){
  if(mode==1){
  setX(getSpeed()+getX());
  if(getX() >= getBorderX() || getX() <= getBorderY()){
  setSpeed(-getSpeed());
  if(getSpeed() > 0)
  setImage("src/images/gnpc"+x+".gif");
  else
  setImage("src/images/gnpc-"+x+".gif");
  }
  }
				
  if(mode==2){
  setY(getSpeed()+getY());
  if(getY() >= getBorderX() || getY() <= getBorderY()){
  setSpeed(-getSpeed());
  if(getSpeed() > 0)
  setImage("src/images/gnpc"+x+".png");
  else
  setImage("src/images/gnpc-"+x+".png");
  }
  }
  clock.restart();
  }

  }
*/
