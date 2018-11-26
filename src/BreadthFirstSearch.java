import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch  extends ASearch
{
	LinkedList<ASearchNode> open;
	LinkedList<ASearchNode> closed;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot (IProblemState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new LinkedList<>();
		closed = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen (ASearchNode node)
	{
		if(open.contains(node)){
			return node;
		}
		else{
			return null;
		}
/*		LinkedList<ASearchNode> tempQueue = new LinkedList<>();
		ASearchNode nodeInOpen = null;
		while (!open.isEmpty()){
			if(open.getFirst().equals(node)){
				nodeInOpen = open.getFirst();
			}
			tempQueue.add(open.removeFirst());
		}
		open = tempQueue;
		return nodeInOpen;*/
	}

	@Override
	public boolean isOpen (ASearchNode node) {
		if (open.contains(node)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isClosed (ASearchNode node)
	{
		if (closed.contains(node)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addToOpen (ASearchNode node)
	{
		open.add(node);
	}

	@Override
	public void addToClosed (ASearchNode node)
	{
 		closed.add(node);
	}

	@Override
	public int openSize() 
	{
		return open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return open.removeFirst();
	}

	

}
