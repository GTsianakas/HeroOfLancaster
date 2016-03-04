
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.Keyboard;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jsfml.system.Vector2f;
//import org.jsfml.audio.*;

public class Driver{

	//Game init
	private View         view        = null;
	private Screen       screen      = null;
	private RenderWindow window      = null;
	private LevelLoader  levelLoader = null;
	private Level        level       = null;
	private MainMenu     mainMenu    = null;
	private PauseMenu    pauseMenu   = null;
	private Loader       loader      = null;
	private DeadMenu     deadMenu    = null;
	private int          levelNum;

	//Level init
	private Map                        map       = null;
	private PlayableCharacter          character = null;
	private ArrayList<CollidableImage> terrain   = null;
	private ArrayList<NpcAI>           npcs      = null;
	private Hud                        hud;
	private ArrayList<HealthPickUp>	   pickUps	= null;
	private boolean                    running  = false;
	private SurvivalMode			   survival = null;
	private Spell ws;
	private Spell es;
	private Spell fs;
	private boolean isSurvival = false; 
	private static final int MAX_LEVEL = 3;

	public Driver(){}

	private void initScreen(){
		screen = new Screen(1024,768,"Hero Of Lancaster!");
		screen.init();
		window = screen.getWindow();
	}
	private void initGame(){
		//save file
		loader = new Loader("src/savefile.txt");
		levelNum = loader.load();
		//Load level factory
		levelLoader = new LevelLoader(); //choose level
		level = null;

		view = (View)window.getView();

		//main menu
		mainMenu = new MainMenu(window,view);
	}

	private void initLevel(){

		//load level attributes
		map = level.getMap();
		character = level.getCharacter();
		terrain = new ArrayList<CollidableImage>();
		npcs = level.getNpcs();
		terrain = map.getTerrain(); //Terrain being areas that cannot be walked upon
		hud = level.getHud();//HUD
		character.meCenter(window,view);

		pickUps = level.getPickup();

		ws = new Spell(character.getX() - 48, character.getY() - 48 , 96, 96, "src/images/spell/water.png");
		es = new Spell(character.getX() - 48, character.getY() - 48 , 96, 96, "src/images/spell/earth.png");
		fs = new Spell(character.getX() - 48, character.getY() - 48 ,400, 22, "src/images/spell/fire.png");
		isSurvival = false;
		
	}

	private void initSurvival(){
		System.out.println("survival in");
		survival = new SurvivalMode();
		map = survival.getMap();
		character = survival.getCharacter();

		terrain = new ArrayList<CollidableImage>();
		npcs = survival.getNpcs();
		terrain = map.getTerrain(); //Terrain being areas that cannot be walked upon
		hud = survival.getHud();//HUD
		character.meCenter(window,view);

		pickUps = survival.getPickup();

		ws = new Spell(character.getX() - 48, character.getY() - 48 , 96, 96, "src/images/spell/water.png");
		es = new Spell(character.getX() - 48, character.getY() - 48 , 128, 128, "src/images/spell/earth.png");
		fs = new Spell(character.getX() - 48, character.getY() - 48 ,400, 22, "src/images/spell/fire.png");
		isSurvival = true;
		running = true;
		
	}

	private void mainMenuLoader(){
		//returns menu option
		int output = mainMenu.run();
		System.out.println("output "+output);

		//new game
		if (output == 1){
			levelNum = 1;
			loader.save(levelNum);
			level = levelLoader.loadLevel(levelNum); //choose level
		} else if (output == -1){ //exit
			window.close();
			System.exit(0);
		} else if (output == 2){
			level = levelLoader.loadLevel(loader.load());//load game from savefile
		} else if (output == 3){
			deadMenu = new DeadMenu(window,view,"src/images/menus/Instructions.png","");
			int out = deadMenu.run();
			//To return to the main menu
			if (out == 1){
				this.run();
			}
		} else if (output == 4){
			initSurvival();

		}
	}

	private void refresh(){
		//draws and positions entities

		map.getBackground().draw(window);
		map.getBackground().move();

		for (CollidableImage t : terrain){// Terrain
			t.draw(window);
			t.move();
		}

		for (CollidableImage npc : npcs){// Npcs
			npc.draw(window);
			npc.move();
		}

		if (es.isSpellCasting() && es.stillCasting()) {
			es.draw(window);
			es.move();
		}

		if (ws.isSpellCasting() && ws.stillCasting()) {
			ws.draw(window);
			ws.move();
		}

		if (fs.isSpellCasting() && fs.stillCasting()) {
			fs.draw(window);
			fs.move();
		}

		for (HealthPickUp pu : pickUps) {
			pu.draw(window);
			pu.move();
		}

		character.draw(window);
		character.move();//put in correct position

		//remove dead npcs
		ArrayList<NpcAI> deadNpc = new ArrayList<NpcAI>();
		for (NpcAI npc : npcs){
			if (npc.getHealth() <= 0){
				deadNpc.add(npc);
			}
		}
		npcs.removeAll(deadNpc);

		hud.setPos((int)view.getCenter().x+350, (int)view.getCenter().y-320);

		//can put green  && ws.checkSpellCoolDown() && fs.checkSpellCoolDown()
		if (es.checkSpellCoolDown() && ws.checkSpellCoolDown() && fs.checkSpellCoolDown()) {
			hud.drawGreenHud(window);
			hud.moveGreen();
			hud.restartClock();
		}
		else {
			hud.drawRedHud(window);
			hud.moveRed();
			hud.updateCD();
			hud.drawCD(window);
		}
		hud.updateHealth(character);
		hud.drawText(window);

	}

	private void eventHandler(){
		// Loops through checking assigned keys for any user input
		for (Event event : window.pollEvents()) {

			//playable character event handling
			character.getEvent(event,es,ws,fs,npcs);

			// the user pressed the close button
			if (event.type == Event.Type.CLOSED) {
				window.close();
				System.exit(0);
			}

			if(event.type == Event.Type.KEY_PRESSED){
				Keyboard key = null;
				if (key.isKeyPressed(Keyboard.Key.ESCAPE) && running){
					running = false;

					pauseMenu = new PauseMenu(window,view);
					int output = pauseMenu.run();
					if (output == 1){
						this.focusView(view,window);
					}else if (output == 2){
						isSurvival = false;
						this.run();
					}
					running = true;
				}

				//zoom for developer aid
				if (key.isKeyPressed(Keyboard.Key.C)){
					view.zoom(1.1f);
					window.setView(view);
				}

				if (key.isKeyPressed(Keyboard.Key.V)){
					view.zoom(0.9f);
					window.setView(view);
				}
			}
		}//event loop
	}

	private void focusView(View view , RenderWindow window){
		view.setCenter(new Vector2f(character.getX(),character.getY()));
		window.setView(view);
	}

	private void physics(){

		//collisions for character
		character.playerCollision(terrain);
		character.playerCollision(npcs);

		//Player actions when moving and screen movement
		character.walk(window,view);

		if (pickUps.size() > 0) {
			ArrayList<HealthPickUp> usedPickUps= new ArrayList<>();
			for (HealthPickUp hpu : pickUps) {
				if (hpu.within(character)) {
					hpu.effect(character);
					usedPickUps.add(hpu);
				}
			}
			pickUps.removeAll(usedPickUps);
		}

		for (NpcAI npc : npcs){// Npcs
			if (ws.isSpellCasting() && ws.within(npc)){
				npc.setHealth(npc.getHealth() - ws.getDamage());
			}
			if (es.isSpellCasting() && es.within(npc)){
				npc.setHealth(npc.getHealth() - es.getDamage());
			}

			if (fs.isSpellCasting() && fs.within(npc)){
				npc.setHealth(npc.getHealth() - fs.getDamage());
			}
			npc.collisionAI(terrain,npcs);
			npc.run(character);
		}
	}

	private void gameLoop(){
		//main game loop
		//(note. to go to next level when you finish a previous it will sent a flag to the level loader to load the new ones will be implementes later)
		while (running && character.getHealth() > 0 ){
				//System.out.println("running");
			this.refresh(); //correctly positions all entities on new location

			this.eventHandler(); //handles all user input during a level

			this.physics(); //handles physics of the game like collisions, AI and attacks

			window.display(); //refresh the display
			//display characters x,y position

			if (isSurvival){
				survival.levelSpecial(npcs);
			}
			 if (npcs.isEmpty()) {
				this.passLevel();
			}
			
		}
	}

	private void passLevel(){
		if(levelNum == MAX_LEVEL){
			levelNum = 1;
		}else{
			++levelNum;
		}
		loader.save(levelNum);
		this.run();
	}

	public void run() throws NullPointerException{

		//initializes screen and displays Main menu
		this.initGame();

		//handles main menu returns
		this.mainMenuLoader();

		//initializes level
		if (!isSurvival){
			this.initLevel();
		}

		running = true;
		this.gameLoop();

		//Death menu starts here
		if (character.getHealth() <= 0){
			isSurvival = false;
			deadMenu = new DeadMenu(window,view);
			int out = deadMenu.run();
			//To return to the main menu
			if (out == 1){
				this.run();
			}
		}

	}//run

	public static void main(String[] args){
		Driver d = new Driver();
		d.initScreen();
		d.run();
	}//main

}
/* music
   public static void ss(){
	
   try {
   Music m = new Music();
   m.openFromFile(Paths.get("src/z.ogg"));
   m.play();
   } catch (IOException ex) {
   ex.printStackTrace();
   }
   }
*/
