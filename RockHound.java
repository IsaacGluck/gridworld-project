import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class RockHound extends Critter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors) {
            if ( !(a instanceof Critter) ) {
                a.removeSelfFromGrid();
            }
        }
    }
}
