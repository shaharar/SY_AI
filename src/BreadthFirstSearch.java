import java.util.LinkedList;

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
		for (ASearchNode Node: open) {
			if(Node.equals(node)){
				return Node;
			}
		}
		return null;
	}

	@Override
	public boolean isOpen (ASearchNode node)
	{
		return (open.contains(node));
	}
	
	@Override
	public boolean isClosed (ASearchNode node)
	{
		return (closed.contains(node));
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
