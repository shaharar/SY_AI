import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	PriorityQueue<ASearchNode> open;
	LinkedList<ASearchNode> closed;

	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() 
	{
		open = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				if (o1.getF() < o2.getF()){
					return -1;
				}
				else if (o1.getF() == o2.getF()){
					return 0;
				}
				return 1;
			}
		});
		closed = new LinkedList<>();
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
        if(isOpen(node)){
            open.remove(node);
        }
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
		return open.poll();
	}

}
