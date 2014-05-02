import info.gridworld.actor.Actor;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;


public class MunchyCritterRunner {
    public static void main (String [] args) {
	ActorWorld world = new ActorWorld();
        MunchyCritter alice = new MunchyCritter ();
	Rock sir = new Rock ();
	world.add(new Location (3,3), sir);
	alice.setColor(Color.ORANGE);
        MunchyCritter bob = new MunchyCritter ();
	world.add(new Location (7,7), alice);
	world.add(new Location (5,5), bob);
	world.show();
    }
}

