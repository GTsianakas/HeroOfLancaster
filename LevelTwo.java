/**
 * Test level not part of final implementation.
 */

import java.util.ArrayList;

public class LevelTwo implements Level{



	Map map = new Map();
	PlayableCharacter  me = new PlayableCharacter(664, 1720, 32, 32, "src/images/me/meFrontWalk.png");
	ArrayList<NpcAI> npcs = new ArrayList<NpcAI>();
	Hud hud = new Hud(me);
	ArrayList<HealthPickUp> pickUps = new ArrayList<HealthPickUp>();


	public LevelTwo(){

		map.addBackground(new Image(100,100, 768, 1024, "src/images/map2/emptyMap.png"));
		map.addTerrain(new CollidableImage(-615, -1100, 3000, 393, "src/images/map2/TreeSet4.png")); //Left
		map.addTerrain(new CollidableImage(-15, -968, 250, 85, "src/images/map2/TreeSet9.png")); //Rihgt
		map.addTerrain(new CollidableImage(36, -839, 120, 955, "src/images/map2/TreeSet3.png")); //Bottom
		map.addTerrain(new CollidableImage(1301, -1109, 3000, 430, "src/images/map2/RightTrees.png")); //SingalLines Left
		map.addTerrain(new CollidableImage(786, -914, 315, 723, "src/images/map2/TreeSet10.png")); //SingalLines Right
		map.addTerrain(new CollidableImage(786, -659, 315, 723, "src/images/map2/TreeSet10.png")); //SingalLines Right
		map.addTerrain(new CollidableImage(-245, -620, 120, 955, "src/images/map2/TreeSet3.png")); //Right bushes
		map.addTerrain(new CollidableImage(563, -530, 250, 143, "src/images/map2/TreeSet121.png")); //Right bushes Below
		map.addTerrain(new CollidableImage(256, -209, 185, 491, "src/images/map2/TreeSet11.png")); //Left Under Single line
		map.addTerrain(new CollidableImage(660, -50, 250, 85, "src/images/map2/TreeSet9.png")); //Left Under 2 below single line
		map.addTerrain(new CollidableImage(370, -50, 250, 85, "src/images/map2/TreeSet9.png")); //Left Under 2 below single line
		map.addTerrain(new CollidableImage(370, 130, 250, 85, "src/images/map2/TreeSet9.png")); //Left Under 2 below single line
		map.addTerrain(new CollidableImage(20, 67, 315, 375, "src/images/map2/TreeSet13.png")); //Left Under 2 below single line
		map.addTerrain(new CollidableImage(430, 259, 120, 491, "src/images/map2/TreeSet2.png")); //Left Under 2 below single line
		map.addTerrain(new CollidableImage(-255, 607, 185, 491, "src/images/map2/TreeSet11.png")); //Right hand side below firstRight hand side single
		map.addTerrain(new CollidableImage(320, 607, 185, 1013, "src/images/map2/TreeSet14.png")); //Right hand side below firstRight hand side single
		map.addTerrain(new CollidableImage(-59, 906, 120, 955, "src/images/map2/TreeSet3.png")); //Right hand side below firstRight hand side single
		map.addTerrain(new CollidableImage(750, 975, 835, 143, "src/images/map2/TreeSet16.png")); //Last large bushes on left hand side
		map.addTerrain(new CollidableImage(-300, 1136, 120, 955, "src/images/map2/TreeSet3.png")); //Last bushes 6*8 right bottom hand side
		map.addTerrain(new CollidableImage(510, 1220, 250, 143, "src/images/map2/TreeSet121.png")); //Last bushes 6*8 right bottom hand side
		map.addTerrain(new CollidableImage(5, 1555, 120, 781, "src/images/map2/TreeSet7.png")); //Middle bushes when spawn
		map.addTerrain(new CollidableImage(-270, -1150, 120, 955, "src/images/map2/TreeSet3.png")); //TOP ------------------------------
		map.addTerrain(new CollidableImage(641, -1150, 120, 955, "src/images/map2/TreeSet3.png")); //TOP ------------------------------
		map.addTerrain(new CollidableImage(-270, 1780, 120, 955, "src/images/map2/TreeSet3.png")); //BOTTOM ------------------------------
		map.addTerrain(new CollidableImage(641, 1780, 120, 955, "src/images/map2/TreeSet3.png")); //BOTTOM ------------------------------
		pickUps.add(new HealthPickUp(469,85,35,35,"src/images/healthPickUpSmaller 2.png"));
		pickUps.add(new HealthPickUp(975,1685,35,35,"src/images/healthPickUpSmaller 2.png"));
		pickUps.add(new HealthPickUp(1195,1685,35,35,"src/images/healthPickUpSmaller 2.png"));

		npcs.add(new Mob1(-180,1492,32,32,"src/images/mob1/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(212,1296,32,32,"src/images/mob2/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(36,1736,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(212,1492,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(695,1100,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(304,1084,32,32,"src/images/mob2/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-128,1084,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-108,864,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(1000,904,32,32,"src/images/mob2/FrontWalk.png",0,0,1)); //changed from 4
		npcs.add(new Mob2(1200,904,32,32,"src/images/mob2/FrontWalk.png",0,0,1)); //changed from 4
		npcs.add(new Mob3(252,516,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-60,484,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-128,-392,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(56,-392,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(176,-292,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(348,-292,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(804,-262,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob1(839,67,32,32,"src/images/mob1/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(855,231,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob3(1019,231,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(1175,99,32,32,"src/images/mob2/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(1175,-173,32,32,"src/images/mob5/FrontWalk.png",0,0,1));

		npcs.add(new NoobBoss(452,-944,32,32,"src/images/2/2fw.png",0,0,2));
	}

	public Hud getHud(){
		return hud;
	}

	public Map getMap(){
		return map;
	}

	public PlayableCharacter getCharacter(){
		return me;
	}

	public ArrayList<NpcAI> getNpcs(){
		return npcs;
	}

	public ArrayList<HealthPickUp> getPickup() {
		return pickUps;
	}

}

