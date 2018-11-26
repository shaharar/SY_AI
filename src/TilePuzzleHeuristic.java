
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		TilePuzzleState tps = (TilePuzzleState) problemState;
		int dimensions = tps._tilePuzzle.length;
		double h = 0;
		int expectedValue = 0;
		for (int row = 0; row < tps._tilePuzzle.length; row++){
			for (int column = 0; column < tps._tilePuzzle[0].length; column++){
				int value = tps._tilePuzzle[row][column];
				expectedValue++;
				if (value != expectedValue && value != 0){
					double verticalDist = (Math.abs(column - ((value - 1) % dimensions))) * value;
					double horizontalDist = (Math.abs(row - ((value - 1) / dimensions))) * value;
					h = h + verticalDist + horizontalDist;
				}
			}
		}
		return h;
	}
}
