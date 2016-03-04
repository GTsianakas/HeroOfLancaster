import java.util.ArrayList;
import java.util.Random;



/**
 * Created by twiggs on 15/02/2016.
 */
public class SurvivalMode implements Level {

    Map map = new Map();
    PlayableCharacter me = new PlayableCharacter (800, 1200, 32, 32, "src/images/me/meBackWalk.png");
    ArrayList<NpcAI> npcs = new ArrayList<NpcAI>();
    Hud hud = new Hud(me);
    ArrayList <HealthPickUp> pickUps = new ArrayList<HealthPickUp>();
    private int maxNFO = 20; //Number of NPCs that spawn per round
    private int score = 0;
    private int numMobs = 0;

    public SurvivalMode()
    {
        //Map
        map.addBackground(new Image(0, 0, 1400, 1400, "src/images/map1/emptyMap.png"));
        map.addTerrain(new CollidableImage(0, 0, 185, 1400, "src/images/map1/TreeSet6.png")); //top border
        map.addTerrain(new CollidableImage(-180, 0, 3000, 393, "src/images/map1/LeftTrees.png")); //left border
        map.addTerrain(new CollidableImage(0, 1400, 185, 2231, "src/images/map1/TreeSet6.png")); //bottom border
        map.addTerrain(new CollidableImage(1400, 0, 3000, 393, "src/images/map1/RightTrees.png")); //right border
        map.addTerrain(new CollidableImage(570, 600, 315, 375, "src/images/map1/TreeSet4.png")); //centre square
        pickUps.add(new HealthPickUp(430,620,35,35,"src/images/healthPickUpSmaller 2.png"));
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

    public ArrayList<HealthPickUp> getPickup(){
        return pickUps;
    }

    public void levelSpecial(ArrayList<NpcAI> npcs) {
        addingPoints(npcs);
        if (npcs.size() == 0) {

            for (int i = 0; i < maxNFO; i++) {
                Random random = new Random();
                int xLocation = random.nextInt(1180) + 233;
                int yLocation = random.nextInt(1100) + 203;

                while( ((xLocation > 552) && (xLocation <960)) && ((yLocation > 577) && (yLocation < 935))  ){
	                xLocation = random.nextInt(1180) + 233;
    	            yLocation = random.nextInt(1100) + 203;
                }

                npcs.add(new Mob1(xLocation, yLocation, 40, 40, "src/images/mob1/LeftWalk.png", 0, 0, 1));
                numMobs +=1;
            }
        }
    }

    public void addingPoints(ArrayList<NpcAI> enmy)
    {
        int difference = numMobs - enmy.size();
       if (difference !=0)
       {
            score += difference *10;
           System.out.println("Score: " + score);
        numMobs = enmy.size();
       }
    }



    public String toString(){
        return "survival";
    }
}



