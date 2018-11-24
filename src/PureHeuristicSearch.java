import java.util.PriorityQueue;

public class PureHeuristicSearch  extends ASearch
{
	PriorityQueue<ASearchNode> open;
	PriorityQueue<ASearchNode> closed;

	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot (IProblemState problemState)
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new PriorityQueue<>();
		closed = new PriorityQueue<>();
	}

	@Override
	public ASearchNode getOpen (ASearchNode node) {
		if (isOpen(node)) {
			return node;
		} else {
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

	}

	@Override
	public void addToClosed (ASearchNode node)
	{

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