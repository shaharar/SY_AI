import java.util.*;

public class UniformCostSearch   extends ASearch
{
	PriorityQueue<ASearchNode> open;
	List<ASearchNode> closed;

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
		open = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				if (o1.getG() < o2.getG()){
					return -1;
				}
				else if (o1.getG() == o2.getG()){
					return 0;
				}
				return 1;
			}
		});
		closed = new ArrayList<>();
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
		return open.poll();
	}

}
