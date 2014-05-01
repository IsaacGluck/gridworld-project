package info.gridworld.actor;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class BlusterCritter extends Critter
{
	private int c; // courage

	public BlusterCritter( int courage ) {
		super();
		c = courage;
	}

    public ArrayList<Actor> getActors()
    {
    	ArrayList<Actor> retActors = new ArrayList<Actor>();
        Location current = getLocation();
        int row = current.getRow();
        int col = current.getCol();

        for (int r = row-2; r<=row+2; r++) {
        	for (int c = col-2; c<=col+2; c++) { // Checks 2 squares away
        		Location checkLoc = new Location(r, c);
        		if (getGrid().isValid(checkLoc) && r!=row && c!=col) { // makes sure the loc is not the current one or off the board
        			if ( getGrid().get(checkLoc) != null ) { // if there is an actor there
        				retActor.add( getGrid().get(checkLoc) ); // add it to actors
        			}
        		}
        	}
        }
        return retActors;
    }


    public void processActors(ArrayList<Actor> actors)
    {
        if (actors.size() > c) {
        	Color c = getColor();
            int red = (int) (c.getRed() * (1 - 0.05));
            int green = (int) (c.getGreen() * (1 - 0.05));
            int blue = (int) (c.getBlue() * (1 - 0.05));
            setColor(new Color(red, green, blue));
        }
        else {
        	Color c = getColor();
            int red = (int) (c.getRed() * (1 + 0.05));
            int green = (int) (c.getGreen() * (1 + 0.05));
            int blue = (int) (c.getBlue() * (1 + 0.05));
            setColor(new Color(red, green, blue));
        }
    }
}
