/**
 * Test level not part of final implementation.
 */

import java.util.ArrayList;

public class LevelThree implements Level{



	Map map = new Map();
	PlayableCharacter  me = new PlayableCharacter(0, -100, 32, 32, "src/images/me/meFrontWalk.png");
	//PlayableCharacter  me = new PlayableCharacter(240,-1820, 32, 32, "src/images/me/meFrontWalk.png");
	ArrayList<NpcAI> npcs = new ArrayList<NpcAI>();
	Hud hud = new Hud(me);
	ArrayList<HealthPickUp> pickUps = new ArrayList<>();

	public LevelThree(){

		map.addBackground(new Image(-2700,-3000, 3760, 4088, "src/images/map3/emptyMap.png"));
		map.addTerrain(new CollidableImage(900,-2900,3000,430,"src/images/map3/Layer-21.png"));
		map.addTerrain(new CollidableImage(-1930,-2900,3000,393,"src/images/map3/Layer-22.png"));
		map.addTerrain(new CollidableImage(437,-925,120,259,"src/images/map3/Layer-15-copy-14.png"));
		map.addTerrain(new CollidableImage(611,-860,185,85,"src/images/map3/Layer-16-copy.png"));
		map.addTerrain(new CollidableImage(610,-731,185,85,"src/images/map3/Layer-16-copy-3.png"));
		map.addTerrain(new CollidableImage(379,-925,214,85,"src/images/map3/Layer-14-copy-6.png"));
		map.addTerrain(new CollidableImage(205,-795,120,259,"src/images/map3/Layer-15-copy-13.png"));
		map.addTerrain(new CollidableImage(900,-1775,640,85,"src/images/map3/Layer-14-copy-37.png"));
		map.addTerrain(new CollidableImage(147,-795,250,85,"src/images/map3/Layer-14-copy-5.png"));
		map.addTerrain(new CollidableImage(147,-600,250,85,"src/images/map3/Layer-14-copy-4.png"));
		map.addTerrain(new CollidableImage(611,-405,250,85,"src/images/map3/Layer-14-copy-3.png"));
		map.addTerrain(new CollidableImage(379,-405,120,259,"src/images/map3/Layer-15-copy-9.png"));
		map.addTerrain(new CollidableImage(147,-405,120,259,"src/images/map3/Layer-15-copy-10.png"));
		map.addTerrain(new CollidableImage(900,-1190,640,85,"src/images/map3/Layer-14-copy-35.png"));
		map.addTerrain(new CollidableImage(437,-210,120,259,"src/images/map3/Layer-15-copy-8.png"));
		map.addTerrain(new CollidableImage(-85,-600,120,259,"src/images/map3/Layer-15-copy-11.png"));
		map.addTerrain(new CollidableImage(726,-605,120,259,"src/images/map3/Layer-15-copy-44.png"));
		map.addTerrain(new CollidableImage(726,-1190,120,259,"src/images/map3/Layer-15-copy-46.png"));
		map.addTerrain(new CollidableImage(494,-605,120,259,"src/images/map3/Layer-15-copy-45.png"));
		map.addTerrain(new CollidableImage(-317,-600,120,259,"src/images/map3/Layer-15-copy-12.png"));
		map.addTerrain(new CollidableImage(-375,-730,250,85,"src/images/map3/Layer-14-copy-9.png"));
		map.addTerrain(new CollidableImage(-375,-535,250,85,"src/images/map3/Layer-14-copy-10.png"));
		map.addTerrain(new CollidableImage(726,-1125,250,85,"src/images/map3/Layer-14-copy-36.png"));
		map.addTerrain(new CollidableImage(-549,-1315,250,85,"src/images/map3/Layer-14-copy-12.png"));
		map.addTerrain(new CollidableImage(-27,-1705,120,259,"src/images/map3/Layer-15-copy-25.png"));
		map.addTerrain(new CollidableImage(-259,-1705,120,259,"src/images/map3/Layer-15-copy-24.png"));
		map.addTerrain(new CollidableImage(-317,-1705,250,85,"src/images/map3/Layer-14-copy-15.png"));
		map.addTerrain(new CollidableImage(-317,-1510,250,85,"src/images/map3/Layer-14-copy-14.png"));
		map.addTerrain(new CollidableImage(-317,-1315,250,85,"src/images/map3/Layer-14-copy-13.png"));
		map.addTerrain(new CollidableImage(-549,-1900,250,85,"src/images/map3/Layer-14-copy-16.png"));
		map.addTerrain(new CollidableImage(-607,-925,250,85,"src/images/map3/Layer-14-copy-20.png"));
		map.addTerrain(new CollidableImage(-607,-405,120,259,"src/images/map3/Layer-15-copy-15.png"));
		map.addTerrain(new CollidableImage(-607,-730,120,259,"src/images/map3/Layer-15-copy-30.png"));
		map.addTerrain(new CollidableImage(-839,-925,120,259,"src/images/map3/Layer-15-copy-31.png"));
		map.addTerrain(new CollidableImage(-839,-405,120,259,"src/images/map3/Layer-15-copy-16.png"));
		map.addTerrain(new CollidableImage(-607,-730,250,85,"src/images/map3/Layer-14-copy-21.png"));
		map.addTerrain(new CollidableImage(-779,-1902,120,259,"src/images/map3/Layer-15-copy-26.png"));
		map.addTerrain(new CollidableImage(668,-1905,120,259,"src/images/map3/Layer-15-copy-51.png"));
		map.addTerrain(new CollidableImage(819,-1782,79,81,"src/images/map3/Layer-20.png"));
		map.addTerrain(new CollidableImage(436,-1905,120,259,"src/images/map3/Layer-15-copy-50.png"));
		map.addTerrain(new CollidableImage(204,-1905,120,259,"src/images/map3/Layer-15-copy-49.png"));
		map.addTerrain(new CollidableImage(-28,-1905,120,259,"src/images/map3/Layer-15-copy-48.png"));
		map.addTerrain(new CollidableImage(610,-1710,250,85,"src/images/map3/Layer-14-copy-40.png"));
		map.addTerrain(new CollidableImage(-260,-1905,120,259,"src/images/map3/Layer-15-copy-47.png"));
		map.addTerrain(new CollidableImage(-839,-600,120,259,"src/images/map3/Layer-15-copy-32.png"));
		map.addTerrain(new CollidableImage(436,-1515,120,259,"src/images/map3/Layer-15-copy-54.png"));
		map.addTerrain(new CollidableImage(-1071,-600,120,259,"src/images/map3/Layer-15-copy-33.png"));
		map.addTerrain(new CollidableImage(-1303,-795,250,85,"src/images/map3/Layer-14-copy-22.png"));
		map.addTerrain(new CollidableImage(378,-1840,250,85,"src/images/map3/Layer-14-copy-38.png"));
		map.addTerrain(new CollidableImage(378,-1645,250,85,"src/images/map3/Layer-14-copy-39.png"));
		map.addTerrain(new CollidableImage(-1303,-600,120,259,"src/images/map3/Layer-15-copy-34.png"));
		map.addTerrain(new CollidableImage(-1185,-1707,120,259,"src/images/map3/Layer-15-copy-29.png"));
		map.addTerrain(new CollidableImage(-779,-1837,250,85,"src/images/map3/Layer-14-copy-17.png"));
		map.addTerrain(new CollidableImage(146,-1515,120,259,"src/images/map3/Layer-15-copy-52.png"));
		map.addTerrain(new CollidableImage(-86,-1515,120,259,"src/images/map3/Layer-15-copy-53.png"));
		map.addTerrain(new CollidableImage(-779,-1642,250,85,"src/images/map3/Layer-14-copy-18.png"));
		map.addTerrain(new CollidableImage(-1187,-535,250,85,"src/images/map3/Layer-14-copy-23.png"));
		map.addTerrain(new CollidableImage(-1187,-405,250,85,"src/images/map3/Layer-14-copy-24.png"));
		map.addTerrain(new CollidableImage(-1243,-1707,250,85,"src/images/map3/Layer-14-copy-19.png"));
		map.addTerrain(new CollidableImage(147,-1120,120,259,"src/images/map3/Layer-15-copy-18.png"));
		map.addTerrain(new CollidableImage(-1011,-1512,120,259,"src/images/map3/Layer-15-copy-27.png"));
		map.addTerrain(new CollidableImage(-1243,-1512,120,259,"src/images/map3/Layer-15-copy-28.png"));
		map.addTerrain(new CollidableImage(-549,-1705,120,259,"src/images/map3/Layer-15-copy-23.png"));
		map.addTerrain(new CollidableImage(-85,-1120,120,259,"src/images/map3/Layer-15-copy-19.png"));
		map.addTerrain(new CollidableImage(-317,-1120,120,259,"src/images/map3/Layer-15-copy-20.png"));
		map.addTerrain(new CollidableImage(-549,-1120,120,259,"src/images/map3/Layer-15-copy-22.png"));
		map.addTerrain(new CollidableImage(-1419,-275,120,259,"src/images/map3/Layer-15-copy-35.png"));
		map.addTerrain(new CollidableImage(-1011,-1902,120,259,"src/images/map3/Layer-15-copy-36.png"));
		map.addTerrain(new CollidableImage(-1243,-1902,120,259,"src/images/map3/Layer-15-copy-37.png"));
		map.addTerrain(new CollidableImage(-1475,-1902,120,259,"src/images/map3/Layer-15-copy-38.png"));
		map.addTerrain(new CollidableImage(-984,-1320,250,85,"src/images/map3/Layer-14-copy-33.png"));
		map.addTerrain(new CollidableImage(-1332,-1320,120,259,"src/images/map3/Layer-15-copy-40.png"));
		//map.addTerrain(new CollidableImage(-1100,-790,120,259,"src/images/map3/Layer-15-copy-42.png")); //This was the problem one
		map.addTerrain(new CollidableImage(-1158,-1125,120,259,"src/images/map3/Layer-15-copy-43.png"));
		map.addTerrain(new CollidableImage(-1564,-1320,120,259,"src/images/map3/Layer-15-copy-39.png"));
		map.addTerrain(new CollidableImage(-1158,-1125,219,85,"src/images/map3/Layer-14-copy-30.png"));
		map.addTerrain(new CollidableImage(-1158,-995,250,85,"src/images/map3/Layer-14-copy-31.png"));
		map.addTerrain(new CollidableImage(-1332,-995,120,256,"src/images/map3/Layer-15-copy-55.png"));
		map.addTerrain(new CollidableImage(-1564,-995,120,259,"src/images/map3/Layer-15-copy-41.png"));
		map.addTerrain(new CollidableImage(-665,-340,250,85,"src/images/map3/Layer-14-copy-11.png"));
		map.addTerrain(new CollidableImage(-1158,-930,250,85,"src/images/map3/Layer-14-copy-32.png"));
		map.addTerrain(new CollidableImage(-1390,-1320,250,85,"src/images/map3/Layer-14-copy-29.png"));
		map.addTerrain(new CollidableImage(-1622,-1775,640,85,"src/images/map3/Layer-14-copy-28.png"));
		map.addTerrain(new CollidableImage(-1622,-605,640,85,"src/images/map3/Layer-14-copy-26.png"));
		map.addTerrain(new CollidableImage(-1622,-1190,640,85,"src/images/map3/Layer-14-copy-27.png"));
		map.addTerrain(new CollidableImage(-1622,-605,640,85,"src/images/map3/Layer-14-copy-25.png"));
		map.addTerrain(new CollidableImage(900,-605,640,85,"src/images/map3/Layer-14-copy-34.png"));
		map.addTerrain(new CollidableImage(-85,-925,250,85,"src/images/map3/Layer-16-copy-2.png"));
		map.addTerrain(new CollidableImage(-839,-210,120,259,"src/images/map3/Layer-15-copy-17.png"));
		map.addTerrain(new CollidableImage(-259,-925,120,259,"src/images/map3/Layer-15-copy-21.png"));
		map.addTerrain(new CollidableImage(-317,-1055,250,85,"src/images/map3/Layer-16.png"));
		map.addTerrain(new CollidableImage(-1533,-1902,120,85,"src/images/map3/Layer-15-copy-3.png"));
		map.addTerrain(new CollidableImage(347,-1315,79,81,"src/images/map3/Layer-23.png"));
		map.addTerrain(new CollidableImage(181,-1339,79,81,"src/images/map3/Layer-24.png"));
		map.addTerrain(new CollidableImage(-41,-1269,79,81,"src/images/map3/Layer-25.png"));
		map.addTerrain(new CollidableImage(-294,-1958,85,54,"src/images/map3/Layer-26.png"));
		map.addTerrain(new CollidableImage(-486,-1958,85,54,"src/images/map3/Layer-27.png"));
		map.addTerrain(new CollidableImage(-1543,-1782,79,81,"src/images/map3/Layer-19.png"));
		map.addTerrain(new CollidableImage(-172,-215,250,85,"src/images/map3/Layer-14.png"));
		map.addTerrain(new CollidableImage(262,-215,250,85,"src/images/map3/Layer-14-copy.png"));
		map.addTerrain(new CollidableImage(262,-215,250,85,"src/images/map3/Layer-14-copy-2.png"));
		map.addTerrain(new CollidableImage(436,-20,120,549,"src/images/map3/Layer-15-copy-7.png"));
		map.addTerrain(new CollidableImage(262,-20,120,201,"src/images/map3/Layer-15-copy-5.png"));
		map.addTerrain(new CollidableImage(204,-20,120,85,"src/images/map3/Layer-15-copy-2.png"));
		map.addTerrain(new CollidableImage(146,-20,120,85,"src/images/map3/Layer-15-copy.png"));
		map.addTerrain(new CollidableImage(88,-20,120,85,"src/images/map3/Layer-15.png"));
		map.addTerrain(new CollidableImage(-1622,-20,120,1535,"src/images/map3/Layer-15-copy-6.png")); //bottom left
		map.addTerrain(new CollidableImage(-1120, -2840, 185, 2231, "src/images/map3/TreeSet6.png"));
		map.addTerrain(new CollidableImage(-1620, -2840, 185, 2231, "src/images/map3/TreeSet6.png"));

		map.addTerrain(new CollidableImage(-110,-20,120,259,"src/images/map3/Layer-15-copy-8.png"));


		//map.addTerrain(new CollidableImage(-594, 900, 315, 723, "images/map1/TreeSet10.png")); //Last large bushes on left hand side
		//map.addTerrain(new CollidableImage(210, 300, 65, 588, "images/horizontal.png"));

		//First mobs
		npcs.add(new Mob2(-230,-400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(-130,-400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(-67,-400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(50,-400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));

		//Directly Above the first 3
		npcs.add(new Mob1(-230,-800,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob1(100,-800,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob1(20,-900,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob1(200,-980,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		//npcs.add(new Mob1(-67,-800,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));

		//First left
		npcs.add(new Mob3(-520,-240,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob3(-520,-160,32,32,"src/images/mob3/FrontWalk.png",0,0,1));


		//Next set to the left
		npcs.add(new Mob3(-1040,-280,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-1000,-400,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-1080,-400,32,32,"src/images/mob4/FrontWalk.png",0,0,1));


		//Bottom left
		npcs.add(new Mob3(-1400,-440,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(-1520,-440,32,32,"src/images/mob2/FrontWalk.png",0,0,1));

		//Just above
		npcs.add(new Mob3(-1400,-600,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(-1520,-600,32,32,"src/images/mob2/FrontWalk.png",0,0,1));

		npcs.add(new Mob3(-1400,-800,32,32,"src/images/mob3/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(-1520,-800,32,32,"src/images/mob2/FrontWalk.png",0,0,1));

		//Up from this
		npcs.add(new Mob3(-400, -940, 32,32,"src/images/mob3/FrontWalk.png",0,0,1));

		//To the right
		npcs.add(new Mob4(-660,-1150,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-800,-1150,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-660,-1220,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-800,-1220,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-660,-1290,32,32,"src/images/mob4/FrontWalk.png",0,0,1));
		npcs.add(new Mob4(-800,-1290,32,32,"src/images/mob4/FrontWalk.png",0,0,1));

		//Up
		npcs.add(new Mob2(50,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(150,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(250,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(400,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(550,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(700,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(850,-1350,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));

		//Pre boss
		npcs.add(new Mob5(-265,-2020,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-465,-2020,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-265,-2100,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-465,-2100,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-265,-2180,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-465,-2180,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-265,-2280,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob5(-465,-2280,32,32,"src/images/mob5/FrontWalk.png",0,0,1));
		npcs.add(new Mob2(-565,-2400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob2(-165,-2400,32,32,"src/images/mob2/FrontWalk.png", 0, 0, 1));

		//Boss
		npcs.add(new EpicBoss(-370, -2500, 90, 52, "src/images/3/rw.png", 1 ,0, 3));

		//Around Boss
		npcs.add(new Mob1(250,-2500,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob1(-990,-2500,32,32,"src/images/mob1/FrontWalk.png", 0, 0, 1));
		npcs.add(new Mob4(-370,-2600,32,32,"src/images/mob4/FrontWalk.png", 0, 0, 1));


		//Health pick-ups
		pickUps.add(new HealthPickUp(524,-254,35,35,"src/images/healthPickUpSmaller 2.png"));
		pickUps.add(new HealthPickUp(780,-1730,35,35,"src/images/healthPickUpSmaller 2.png"));
		pickUps.add(new HealthPickUp(850,-2050,35,35,"src/images/healthPickUpSmaller 2.png"));

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

	public void levelSpecial(){
		//do nothing
	}
}

