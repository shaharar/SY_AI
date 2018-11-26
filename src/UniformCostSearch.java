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
		if(open.contains(node)){
			return node;
		}
		else{
			return null;
		}

/*		Iterator<ASearchNode> it = open.iterator();
		ASearchNode nodeInOpen = null;
		while (it.hasNext()){
			nodeInOpen = it.next();
			if(nodeInOpen.equals(node)){
				return nodeInOpen;
			}
		}
		return nodeInOpen;*/

		    /*PriorityQueue<ASearchNode> tempQueue = new PriorityQueue<>();
		    ASearchNode nodeInOpen = null;
		    while (!open.isEmpty()){
		        if(open.peek().equals(node)){
		            nodeInOpen = open.peek();
                }
                tempQueue.add(open.poll());
            }
            open = tempQueue;
			return nodeInOpen;*/


	}

	@Override
	public boolean isOpen (ASearchNode node) {

/*		Iterator<ASearchNode> it = open.iterator();
		ASearchNode nodeInOpen = null;
		while (it.hasNext()){
			nodeInOpen = it.next();
			if(nodeInOpen.equals(node)){
				return true;
			}
		}
		return false;*/

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
		return open.poll();
	}

}
