import java.util.*;

public class UniformCostSearch   extends ASearch
{
	PriorityQueue<ASearchNode> open;
	LinkedList<ASearchNode> closed;

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
		closed = new LinkedList<>();
	}

	@Override
	public ASearchNode getOpen (ASearchNode node)
	{
		if(isOpen(node)){
		    PriorityQueue<ASearchNode> tempQueue = new PriorityQueue<>();
		    ASearchNode nodeInOpen = null;
		    while (!open.isEmpty()){
		        if(open.peek().equals(node)){
		            nodeInOpen = open.peek();
                }
                tempQueue.add(open.poll());
            }
            open = tempQueue;
			return nodeInOpen;
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
