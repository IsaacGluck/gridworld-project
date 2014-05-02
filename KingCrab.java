import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;

import java.util.ArrayList;
import java.awt.Color;

/*  A KingCrab gets actors to be processed in the same way a CrabCritter does. A KingCrab causes each actor that it processes to move one location further away from the kingCrab. If actor cannot move away, the KingCrab removes it from the grid. When kingCrab has completed processing the actors, it moves like a CrabCritter*/

public class KingCrab extends CrabCritter{

    public KingCrab() {
	super();
	setColor(Color.YELLOW);
    }
    public void processActors(ArrayList <Actor> actors) {
	for (Actor a:actors) {

	    Location loc = a.getLocation();
	    Grid gr = getGrid();
	    ArrayList<Location> locs = new ArrayList<Location>();
	    int[] dirs =
		{ Location.LEFT, Location.RIGHT };
	    for (Location l : getLocationsInDirections(dirs))
		if (getGrid().get(l) == null)
		    locs.add(l);
	    if (locs.size() == 0){
		super.processActors(actors);
	    }
	    else {
		int r = (int)(Math.random() * locs.size());
		a.moveTo(locs.get(r));
		
	    }
	}
    }
}
