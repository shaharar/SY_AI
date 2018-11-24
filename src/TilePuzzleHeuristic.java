
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		TilePuzzleState tps = (TilePuzzleState) problemState;
		double h = 0;
		for (int i = 0; i < tps._tilePuzzle.length; i++){
			for (int j = 0; j < tps._tilePuzzle[i].length; i++){
				double verticalDist = (Math.abs(tps._zeroCol - 0)) * tps._tilePuzzle[i][j];
				double horizontalDist = (Math.abs(tps._zeroRow - 0)) * tps._tilePuzzle[i][j];
				h = h + verticalDist + horizontalDist;
			}
		}
		return h;
	}
	
}
