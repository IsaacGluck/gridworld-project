//Jim Yuan
//APCS2 pd8
//HW35
//2014-04-30

public class SparseGridNode{
    private Object _occupant;
    private int _col;
    private SparseGridNode _next;


    public SparseGridNode(int col, Object occupant, SparseGridNode next){
	_col = col;
	_occupant = occupant;
	_next = next;
    }
    
    public Object getOccupant(){
	return _occupant;
    }
    
    public SparseGridNode getNext(){
	return _next;
    }

    public int getCol(){
	return _col;
    }
    
}
