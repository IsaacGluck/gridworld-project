//Jim Yuan
//APCS2 pd8
//HW35
//2014-04-30

//uses a "sparse array" implementation
//gonna want an array of the whole map
//have a second one that lists the things that are actually present
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location

public class SparseBoundedGrid implements Grid{
    //sparse array - an array list of linked lists
    //linked list entries hold grid occupant and column index
    //each entry in array list is linked list or null if empty row
    ArrayList<SparseGridNode> sparray;
    
    public SparseBoundedGrid(){
	sparray = new ArrayList<SparseGridNode>();
    }
    
    
    
    
    
    
}
