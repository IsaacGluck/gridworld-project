//Jim Yuan
//APCS2 pd8
//HW35
//2014-04-30



//Exercise 1
//This is a more time-efficient impementation than BoundedGrid because
//there is no need to cycle through each and every element in the grid
//to find occupied locations
//uses a "sparse array" implementation
//gonna want an array of the whole map
//have a second one that lists the things that are actually present
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid implements Grid<Object>{
    //sparse array - an array list of linked lists
    //linked list entries hold grid occupant and column index
    //each entry in array list is linked list or null if empty row
    ArrayList<SparseGridNode> sparray;
    ArrayList<Location> loc;
    int _numRows;    
    
    public SparseBoundedGrid(int rows){
	sparray = new ArrayList<SparseGridNode>(rows);
	_numRows = rows;
    }
    
    
    //returns cargo at the given location
    public Object get(Location loc){
	SparseGridNode curr = sparray.get(loc.getRow());
	for(int i = 0; i < loc.getCol(); i++){
	    curr = curr.getNext();
	}
	return curr.getOccupant();
    }
    
    public int getNumRows(){
	return _numRows();
    }
    
    public int getNumCols(){
	int cols = 0;
	SparseGridNode tmp = sparray.get(0);
	for(int i = 0; i < getNumRows(); i++){
	    tmp = tmp.getNext();
	    cols++;
	}
	return cols;
	
    }
    
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	    && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    
    //returns the locations empty in the 1 surrouding squares
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc){
	ArrayList<Location> eadj = new ArrayList<Location>();
	//same format eight times
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	if(new Location(loc.getRow() + 1, loc.getCol())){
	    eadj.add(new Location(loc.getRow() + 1, loc.getCol()));
	}
	
    }    
    
}
