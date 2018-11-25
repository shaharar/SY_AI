
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic (IProblemState problemState)
	{
		TilePuzzleState tps = (TilePuzzleState) problemState;
		int dimensions = tps._tilePuzzle.length;
		double h = 0;
		int expectedValue = 0;
		for (int row = 0; row < tps._tilePuzzle.length; row++){
			for (int column = 0; column < tps._tilePuzzle[row].length; column++){
				int value = tps._tilePuzzle[row][column];
				expectedValue++;
				if (value != expectedValue && value != 0){
					double verticalDist = (Math.abs(tps._zeroCol - getColGoalState(dimensions, value))) * value;
					double horizontalDist = (Math.abs(tps._zeroRow - getRowGoalState(dimensions, value))) * value;
					h = h + verticalDist + horizontalDist;
				}
			}
		}
		return h;
	}

	private double getColGoalState(int dimensions, int value) {
		if (dimensions == 3){
			if (value == 1 || value == 4|| value == 7){
				return 0;
			}
			else if (value == 2 || value == 5 || value == 8){
				return 1;
			}
			else if (value == 3 || value == 6 || value == 0){
				return 2;
			}
		}
		else if (dimensions == 4){
			if (value == 1 || value == 5|| value == 9 || value == 13){
				return 0;
			}
			else if (value == 2 || value == 6 || value == 10 || value == 14){
				return 1;
			}
			else if (value == 3 || value == 7 || value == 11 || value == 15){
				return 2;
			}
			else if (value == 4 || value == 8 || value == 12 || value == 0){
				return 3;
			}
		}
		return -1;
	}

	private double getRowGoalState(int dimensions, int value) {
		if (dimensions == 3){
			if (value == 1 || value == 2|| value == 3){
				return 0;
			}
			else if (value == 4 || value == 5 || value == 6){
				return 1;
			}
			else if (value == 7 || value == 8 || value == 0){
				return 2;
			}
		}
		else if (dimensions == 4){
			if (value == 1 || value == 2|| value == 3 || value == 4){
				return 0;
			}
			else if (value == 5 || value == 6 || value == 7 || value == 8){
				return 1;
			}
			else if (value == 9 || value == 10 || value == 11 || value == 12){
				return 2;
			}
			else if (value == 13 || value == 14 || value == 15 || value == 0){
				return 3;
			}
		}
		return -1;
	}

}
