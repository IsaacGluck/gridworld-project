package info.gridworld.actor;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/*  A KingCrab gets actors to be processed in the same way a CrabCritter does. A KingCrab causes each actor that it processes to move one location further away from the kingCrab. If actor cannot move away, the KingCrab removes it from the grid. When kingCrab has completed processing the actors, it moves like a CrabCritter*/

public class KingCrab extends CrabCritter{
    /*
