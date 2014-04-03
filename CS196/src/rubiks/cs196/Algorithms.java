/**
 * Algorithms class
 * contains algorithms: sets of permutations
 * DONT FORGET TO SET CUBE ORIENTATION BEFORE DOING ALGS
 */
public class Algorithms extends Permutation {

	// an algorithm - see ryanheise.com/cube/beginner.html ->
	// "Swap the incorrect cross pieces"
	public static void swapCrossPieces(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: //adjacent faced pairs
			rotate180(RIGHT);
			rotateCW(UP);
			rotate180(FRONT);
			rotateCCW(UP);
			rotate180(RIGHT);
			break;
		case 2: //opposite faced pairs
			rotate180(RIGHT);
			rotate180(UP);
			rotate180(FRONT);
			rotate180(UP);
			rotate180(RIGHT);
			break;
		case 3: //rotate bottom face to match pairs initially
			rotateCW(DOWN);
			break;
		}
	}
	
	public static void insertBottomCorners(int caseNum){
		if (caseNum < 1 || caseNum > 5){
			throw new RuntimeException("Invalid case number " + caseNum);
		}
		switch (caseNum){
		case 1: //yellow piece is in bottom layer, bring it up top
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			break;
		case 2: //
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		
		}	
	}

	//more algorithms will be written out here...
}
