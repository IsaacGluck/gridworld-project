package info.gridworld.actor;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/*  A QuickCrab moves to one of the two locations, randomly selected, that are two spaces to its right or left, if that location and the intervening location are both empty. Otherwise, a QuickCrab moves like a CrabCritter.*/

public class QuickCrab extends CrabCritter{
    /*
     * Finds the valid adjacent locations 2 cells over of this critter in different directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are two spaces of the current
     * location in the given directions (left and right)
     */

    public ArrayList<Location> getLocationsInDirections2(int[] directions){
	ArrayList <Location> locs = new ArrayList<Location>();
	Grid gr = getGrid();
	Location loc = getLocation();
	
	for (int d: directions)
	    {
		Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
		if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null) {
		    Location neighborLoc2 = neighborLoc.getAdjacentLocation(getDirection() +d));
		    if (gr.isValid(neighborLoc2)){
			locs.add(neighborLoc2);
		    }
		}
		    
	    }
	return locs;
    }

    public ArrayList<Location> getMoveLocations2(){
	ArrayList<Location> locs = new ArrayList<Location>();
	int[] dirs = { Location.LEFT, Location.RIGHT };
	for (Location loc : getLocationsInDirections2(dirs))
	    if (getGrid().get(loc) == null)
		locs.add(loc);
	return locs;
    }

  
    public void act(){
	if (getMoveLocations2().size() == 0){
	    super.act();
		}
	else{
	    if (getGrid() == null)
		return;
	    ArrayList<Actor> actors = getActors();
	    processActors(actors);
	    ArrayList<Location> moveLocs = getMoveLocations2();
	    Location loc = selectMoveLocation(moveLocs);
	    makeMove(loc);
	}
    }
}

