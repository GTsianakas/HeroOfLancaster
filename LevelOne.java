/**
 * Test level not part of final implementation.
 */

import java.util.ArrayList;

public class LevelOne implements Level{
	
	
    Map map = new Map();
    PlayableCharacter  me = new PlayableCharacter(-440, 1360, 32, 32, "src/images/me/meFrontWalk.png");
    ArrayList<NpcAI> npcs = new ArrayList<NpcAI>();
	Hud hud = new Hud(me);
	ArrayList<HealthPickUp> pickUps = new ArrayList<HealthPickUp>();

	public LevelOne(){
	
	//map.addBackground(new Image(0,0, 768, 1024, "images/kingRoom/kingsRoomBackground.png"));
	map.addBackground(new Image(100,100, 768, 1024, "src/images/map1/emptyMap.png"));
	map.addTerrain(new CollidableImage(-1000, -1100, 3000, 393, "src/images/map1/LeftTrees.png")); //Left
	map.addTerrain(new CollidableImage(1600, -1094, 3000, 375, "src/images/map1/RightTrees.png")); //Rihgt
	map.addTerrain(new CollidableImage(-601, 1526, 185, 2231, "src/images/map1/TreeSet6.png")); //Bottom
	map.addTerrain(new CollidableImage(-445, -1100, 510, 85, "src/images/map1/TreeSet1.png")); //SingalLines Left
	map.addTerrain(new CollidableImage(70, -1100, 510, 85, "src/images/map1/TreeSet1.png")); //SingalLines Right
	map.addTerrain(new CollidableImage(-137, -730, 510, 85, "src/images/map1/TreeSet1.png")); //SingalLines Right
	map.addTerrain(new CollidableImage(800, -944, 315, 723, "src/images/map1/TreeSet10.png")); //Right bushes
	map.addTerrain(new CollidableImage(1260, -580, 315, 375, "src/images/map1/TreeSet4.png")); //Right bushes Below
	map.addTerrain(new CollidableImage(-254, -254, 315, 723, "src/images/map1/TreeSet10.png")); //Left Under Single line
	map.addTerrain(new CollidableImage(-620, 146, 315, 723, "src/images/map1/TreeSet10.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(80, 146, 315, 375, "src/images/map1/TreeSet4.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(786, -314, 315, 375, "src/images/map1/TreeSet4.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(786, -40, 315, 375, "src/images/map1/TreeSet4.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(786, 230, 315, 375, "src/images/map1/TreeSet4.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(786, 500, 315, 375, "src/images/map1/TreeSet4.png")); //Left Under 2 below single line
	map.addTerrain(new CollidableImage(1251, -124, 510, 85, "src/images/map1/TreeSet1.png")); //Right hand side below firstRight hand side single
	map.addTerrain(new CollidableImage(1251, 306, 510, 85, "src/images/map1/TreeSet1.png")); //Right hand side below firstRight hand side single
	map.addTerrain(new CollidableImage(1251, 960, 315, 375, "src/images/map1/TreeSet4.png")); //Right hand side below firstRight hand side single
	map.addTerrain(new CollidableImage(-620, 586, 575, 723, "src/images/map1/TreeSet3.png")); //Last large bushes on left hand side
	map.addTerrain(new CollidableImage(246, 751, 315, 375, "src/images/map1/TreeSet4.png")); //Last bushes 6*8 right bottom hand side
	map.addTerrain(new CollidableImage(246, 950, 315, 375, "src/images/map1/TreeSet4.png")); //Last bushes 6*8 right bottom hand side
	map.addTerrain(new CollidableImage(435, -55, 315, 375, "src/images/map1/TreeSet4.png")); //Middle bushes when spawn
	map.addTerrain(new CollidableImage(435, 200, 315, 375, "src/images/map1/TreeSet4.png")); //Middle bushes when spawn
	map.addTerrain(new CollidableImage(150, -1093, 75, 1479, "src/images/map1/TreeSet11.png")); //Last large bushes on left hand side
	map.addTerrain(new CollidableImage(-619, -1098, 75, 1479, "src/images/map1/TreeSet11.png"));
	pickUps.add(new HealthPickUp(430,620,35,35,"src/images/healthPickUpSmaller 2.png"));

	npcs.add(new MeleeBoss(305,-921,100,100,"src/images/1/1FrontWalk.png",0,0,1));
	
	npcs.add(new Mob1(152,1368,40,40,"src/images/mob1/LeftWalk.png",0,0,1));
	npcs.add(new Mob1(400,600,50,50,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(-425,516,40,40,"src/images/mob1/RightWalk.png",0,0,1));
	npcs.add(new Mob1(1048,936,40,40,"src/images/mob1/LeftWalk.png",0,0,1));
	npcs.add(new Mob2(1512,1400,40,40,"src/images/mob2/RightWalk.png",0,0,1));//bit hard
	npcs.add(new Mob1(1188,-88,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1200,-64,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1570,40,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1580,280,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1464,112,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1456,452,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1348,636,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1560,868,40,40,"src/images/mob1/LeftWalk.png",0,0,1));
	npcs.add(new Mob1(1184,400,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(1212,-298,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob2(1552,-616,40,40,"src/images/mob2/LeftWalk.png",0,0,1));//bit hard
	npcs.add(new Mob1(1564,-988,40,40,"src/images/mob1/LeftWalk.png",0,0,1));
	npcs.add(new Mob1(992,-984,40,40,"src/images/mob1/LeftWalk.png",0,0,1));
	npcs.add(new Mob2(464,-300,40,40,"src/images/mob2/RightWalk.png",0,0,1));//bit hard
	npcs.add(new Mob1(228,-868,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob1(352,-952,40,40,"src/images/mob1/RightWalk.png",0,0,1));
	npcs.add(new Mob1(4,-816,40,40,"src/images/mob1/FrontWalk.png",0,0,1));
	npcs.add(new Mob2(-400,-420,40,40,"src/images/mob2/BackWalk.png",0,0,1));//bit hard
	
	
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
 
    public Hud getHud(){
	return hud;
    }

	public ArrayList<HealthPickUp> getPickup() {
		return pickUps;
	}

	public void levelSpecial(){
		//do nothing
	}
	
}

