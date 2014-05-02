import info.gridworld.actor.Actor;
//import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.io.*;
import java.util.*;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

/*****************************************************************
NAME: Ben Rothman, Jim Yuan, Isaac Gluck, Alicia Chen
TEAM NAME: gw450-psychic-octo-meme

git@github.com:IsaacGluck/gw45-psychic-octo-meme.git

APCS pd 8

HW35 -- GridWorld, Part 5

2014-05-01

*
* class MunchyCritter
*
* BEACUASE:
* We chose to implement MunchyCritter because the Specs were detailed instructions, the Test Cases were easy to follow, and it was the most interesting out of all the options presented to us. 
*
* SPECIFICATIONS:
*
MunchyCritter will extend Critter. A MunchyCritter looks at all of the neighbors within one step of its current location. It will then proceed to eat (remove) all actors within one stepo of its current location. However, if the actor that is removed is a Rock, then the MunchyCritter dies. If there are no actors within a one step radius of its current location, the MunchyCritter will move in a random direction for one step.
*
* TEST CASES:
* 
First Test Case: A MunchyCritter is placed in a grid where there are only actors except for Rocks. 
The MunchyCritter would be able to eat anything in its radius and keep moving if there is nothing to eat.
Second Test Case: A MunchyCritter is placed in a grid where there are only actors that are Rocks.
The MunchyCritter move around and then if it encounters a rock, it will eat and then proceed to "die" or remove itself.
Third Test Case: A MunchyCritter is placed at the edge of the grid.
It should be able to discern which direction is a valid location to step in and proceed to step in the correct path.
Fourth Test Case: When the MunchyCritter is surrounded by Actors other than Rocks.
All Actors should be consumed.
Fifth Test Case: When the MunchyCritter is surrounde by Rocks
All rocks should be consumed and the MunchyCritter will remove itself. 
*
* ERRATA:
* We had to rewrite the Act Method, even though Gridworld doesn't recommend it to deal with deleting ourselves.
*****************************************************************/
//It's behavior is different from BoxBug in that it turns only once instead of twice, creating a octoganal figure that looks similar to a circle with a radius slightly larger than sideLength.

public class MunchyCritter extends Critter {

    private boolean _eatenRock;
    private boolean _eaten;

    public MunchyCritter() {
	super();
	_eatenRock = false;
	_eaten = false;
    }

    public void act () { //Sorry Gridworld..You only had one rule and we had to break it :'(. 
	if (getGrid() == null) {
	    return;
	}

	ArrayList<Actor> actors = getActors();
	processActors (actors);
	if (!_eatenRock) {
	    ArrayList <Location> moveLocs = getMoveLocations();
	    Location loc = selectMoveLocation(moveLocs);
	    makeMove (loc);
	}
    }

    public void processActors (ArrayList <Actor> actors) {
	for (Actor a : actors) {
	    if (!(a instanceof Rock) && !(a instanceof Critter)) {
		a.removeSelfFromGrid();
		_eaten = true;
	    }
	    if (a instanceof Rock) {
		_eatenRock = true;
		a.removeSelfFromGrid();
	    }
	}

	if (_eatenRock) {
	    removeSelfFromGrid();
	}
    }


    public void makeMove (Location loc) {
	if (loc ==null) {
	    removeSelfFromGrid();}
	else {
	    if (!_eaten) {
		moveTo(loc);
	    }
	    else {
		_eaten = false;
	    }
	}
    }
}
