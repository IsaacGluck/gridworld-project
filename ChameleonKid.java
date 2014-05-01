import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors) {
        infront = getGrid().get( getLocation().getAdjacentLocation( getDirection() ) );
        behind = getGrid().get( getLocation().getAdjacentLocation( (getDirection() + 180) % 360 ) );
        if (infront != null) {
            setColor(infront.getColor());
        }
        else if (behind != null) {
            setColor(behind.getColor());
        }
        else {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - 0.05));
            int green = (int) (c.getGreen() * (1 - 0.05));
            int blue = (int) (c.getBlue() * (1 - 0.05));
            setColor(new Color(red, green, blue));
        }
    }

}
