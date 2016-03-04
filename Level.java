/**
 * Level Interface; this interface is implemented by every diferent level created,
 *  to be able to be called by the LevelLoader class.
 */

import java.util.ArrayList;

public interface Level{
    
    public Map getMap();
    
    public PlayableCharacter getCharacter();
    
    public ArrayList<NpcAI> getNpcs();

    public Hud getHud();

    public ArrayList<HealthPickUp> getPickup();

}
