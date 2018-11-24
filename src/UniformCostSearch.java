import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch   extends ASearch
{
	PriorityQueue<ASearchNode> open;
	PriorityQueue<ASearchNode> closed;
	LinkedList<ASearchNode> tempLinkedList;

	@Override
	public String getSolverName() 
	{
		return "UCS";
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
		open = new PriorityQueue<>();
		closed = new PriorityQueue<>();
		tempLinkedList = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen (ASearchNode node)
	{
		if(isOpen(node)){
			return node;
		}
		else{
			return null;
		}
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
		while (node.getG() < open.peek().getG()){
			tempLinkedList.add(open.poll());
		}
		open.add(node);
		while (! tempLinkedList.isEmpty()){
			open.add(tempLinkedList.remove());
		}
	}

	@Override
	public void addToClosed (ASearchNode node)
	{
		List<ASearchNode> neighbors = node.getNeighbors();
		for (ASearchNode neighbor: neighbors) {
			closed.add(neighbor);
		}
	}

	@Override
	public int openSize() 
	{
		return open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return open.poll();
	}

}
