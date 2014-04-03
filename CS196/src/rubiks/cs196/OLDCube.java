//RETIRED CODE name Cube changed to OLDCube
//class Cube
/*
 * using Ryan Heise's beginner method
 * http://www.ryanheise.com/cube/beginner.html
 * 
 */

/**
class Cube {

	static int FRONT = 0;
	static int RIGHT = 1;
	static int BACK = 2;
	static int LEFT = 3;
	static int UP = 4;
	static int DOWN = 5;

	final static int GREEN = 0;
	final static int RED = 1;
	final static int BLUE = 2;
	final static int ORANGE = 3;
	final static int WHITE = 4;
	final static int YELLOW = 5;

	// 6 faces, 3 rows, 3 columns
	private char faces[][][] = new char[6][3][3];
	private int orientation = FRONT;

	// public static char completeCube[][][] = new char[6][3][3];

	// Cube constructor
	// initializes faces to a scrambled or completed cube
	Cube(boolean scrambled) {
		if (scrambled)
			faces = Cube.scrambledCube();
		else
			faces = Cube.completeCube();
	}

	// gets input from console for each row of face
	public void setFace(int side) {
		String str = "";
		for (int row = 0; row < 3; row++) {
			TextIO.putln("Enter row " + (row + 1) + " of cube colors for face "
					+ (side + 1) + " as G,B,R,O,W, or Y\nSuch as \"GBR\"");
			str = TextIO.getln();
			for (int col = 0; col < 3; col++) {
				faces[side][row][col] = str.toLowerCase().charAt(col);
			}
		}
	}

	// gets input from console for all faces
	public void setAllFaces() {
		for (int i = 0; i < 6; i++) {
			setFace(i);
		}
	}

	// points faces[][][] to a new cube array
	public void setAllFaces(char[][][] array) {
		faces = array;
	}

	// returns pointer to array of completed cube
	public static char[][][] completeCube() {
		char[][][] cube = new char[6][3][3];
		String str = "GGGGGGGGGBBBBBBBBBRRRRRRRRROOOOOOOOOWWWWWWWWWYYYYYYYYY";
		// String str =
		// "rrbggyggybbwbbwgggwoorrbrrbrryoooooowwwwwwggryybyybyyo";
		int nextChar = 0;
		for (int face = 0; face < 6; face++) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					cube[face][row][col] = str.toUpperCase().charAt(nextChar++);
				}
			}
		}
		return cube;
	}

	// returns pointer to array of scrambled cube
	public static char[][][] scrambledCube() {
		char[][][] cube = new char[6][3][3];
		for (int face = 0; face < 6; face++) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					cube[face][row][col] = randomColor();
				}
			}
		}
		return cube;
	}

	// returns a random color as a character
	public static char randomColor() {
		int randInt = (int) (Math.random() * 6);
		char randChar;
		switch (randInt) {
		case 1:
			randChar = 'G';
			break;
		case 2:
			randChar = 'B';
			break;
		case 3:
			randChar = 'R';
			break;
		case 4:
			randChar = 'O';
			break;
		case 5:
			randChar = 'W';
			break;
		case 6:
			randChar = 'Y';
			break;
		default:
			randChar = 'G';
			break;
		}
		return randChar;
	}

	// prints the face to console
	public void printFace(int side) {
		String str = "";
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				str += faces[side][row][col] + " ";
			}
			TextIO.putln(str);
			str = "";
		}
		TextIO.putln();
	}

	// prints all faces to console
	public void printAllFaces() {
		for (int i = 0; i < 6; i++) {
			printFace(i);
		}
	}

	// returns the color at specified position
	public char colorAt(int side, int row, int col) {
		return faces[side][row][col];
	}

	// algorithm one
	public boolean algOne() {
		// search cube for wanted colors
		// when colors are found, employ combinations of basic
		// movement methods on the array faces. (still need to be written)
		return true; // should return false if method is completed successfully,
						// true if error
	}

	public void setOrientation(int orient) {
		orientation = orient;
		switch (orientation) {
		case GREEN:
			FRONT = GREEN;
			BACK = BLUE;
			RIGHT = RED;
			LEFT = ORANGE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case BLUE:
			FRONT = BLUE;
			BACK = GREEN;
			RIGHT = ORANGE;
			LEFT = RED;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case RED:
			FRONT = RED;
			BACK = ORANGE;
			RIGHT = BLUE;
			LEFT = GREEN;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case ORANGE:
			FRONT = ORANGE;
			BACK = RED;
			RIGHT = GREEN;
			LEFT = BLUE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case WHITE:
			FRONT = WHITE;
			BACK = YELLOW;
			RIGHT = RED;
			LEFT = ORANGE;
			UP = BLUE;
			DOWN = GREEN;
			break;
		case YELLOW:
			FRONT = YELLOW;
			BACK = WHITE;
			RIGHT = RED;
			LEFT = ORANGE;
			UP = GREEN;
			DOWN = BLUE;
			break;
		}
	}

	public void printOrientation() {
		TextIO.putln("ORIENTATION: " + orientation);
		TextIO.putln("Front: " + FRONT);
		TextIO.putln("Back: " + BACK);
		TextIO.putln("RIGHT: " + RIGHT);
		TextIO.putln("LEFT: " + LEFT);
		TextIO.putln("UP: " + UP);
		TextIO.putln("DOWN: " + DOWN);
	}

	// turns the face to the right of the current orientation clockwise
	public char[][][] RightRotationCW() {

		char temp1, temp2, temp3;

		// swapped right and left columns to keep orientation consistent
		temp1 = faces[UP][1 - 1][3 - 1];
		temp2 = faces[UP][2 - 1][3 - 1];
		temp3 = faces[UP][3 - 1][3 - 1];

		faces[UP][1 - 1][3 - 1] = faces[FRONT][1 - 1][3 - 1];
		faces[UP][2 - 1][3 - 1] = faces[FRONT][2 - 1][3 - 1];
		faces[UP][3 - 1][3 - 1] = faces[FRONT][3 - 1][3 - 1];

		faces[FRONT][1 - 1][3 - 1] = faces[DOWN][1 - 1][3 - 1];
		faces[FRONT][2 - 1][3 - 1] = faces[DOWN][2 - 1][3 - 1];
		faces[FRONT][3 - 1][3 - 1] = faces[DOWN][3 - 1][3 - 1];

		faces[DOWN][1 - 1][3 - 1] = faces[BACK][1 - 1][3 - 1];
		faces[DOWN][2 - 1][3 - 1] = faces[BACK][2 - 1][3 - 1];
		faces[DOWN][3 - 1][3 - 1] = faces[BACK][3 - 1][3 - 1];

		// swapped right and left columns to keep orientation consistent
		faces[BACK][1 - 1][1 - 1] = temp1;
		faces[BACK][2 - 1][1 - 1] = temp2;
		faces[BACK][3 - 1][1 - 1] = temp3;
		// Rotates right column of chosen face and changes value for each
		// part of that column

		temp1 = faces[RIGHT][1 - 1][2 - 1];
		faces[RIGHT][1 - 1][2 - 1] = faces[RIGHT][2 - 1][1 - 1];
		faces[RIGHT][2 - 1][1 - 1] = faces[RIGHT][3 - 1][2 - 1];
		faces[RIGHT][3 - 1][2 - 1] = faces[RIGHT][2 - 1][3 - 1];
		faces[RIGHT][2 - 1][3 - 1] = temp1;

		temp2 = faces[RIGHT][1 - 1][1 - 1];
		faces[RIGHT][1 - 1][1 - 1] = faces[RIGHT][3 - 1][1 - 1];
		faces[RIGHT][3 - 1][1 - 1] = faces[RIGHT][3 - 1][3 - 1];
		faces[RIGHT][3 - 1][3 - 1] = faces[RIGHT][1 - 1][3 - 1];
		faces[RIGHT][1 - 1][3 - 1] = temp2;
		// Rotates face adjacent to right column
		return faces;// Returns new rubik's cube
	}

	private void rotateArray(int face, int times) {
		for (int i = 0; i < times; i++) {
			char temp1 = faces[face][1 - 1][2 - 1];
			faces[face][1 - 1][2 - 1] = faces[face][2 - 1][1 - 1];
			faces[face][2 - 1][1 - 1] = faces[face][3 - 1][2 - 1];
			faces[face][3 - 1][2 - 1] = faces[face][2 - 1][3 - 1];
			faces[face][2 - 1][3 - 1] = temp1;

			char temp2 = faces[face][1 - 1][1 - 1];
			faces[face][1 - 1][1 - 1] = faces[face][3 - 1][1 - 1];
			faces[face][3 - 1][1 - 1] = faces[face][3 - 1][3 - 1];
			faces[face][3 - 1][3 - 1] = faces[face][1 - 1][3 - 1];
			faces[face][1 - 1][3 - 1] = temp2;
		}
	}

	public void rotateFace(int face) {
		setOrientation(face);

		char temp1, temp2, temp3;

		switch (face) {
		case GREEN:
			temp1 = faces[UP][3 - 1][1 - 1];
			temp2 = faces[UP][3 - 1][2 - 1];
			temp3 = faces[UP][3 - 1][3 - 1];

			faces[UP][3 - 1][3 - 1] = faces[LEFT][1 - 1][3 - 1];
			faces[UP][3 - 1][2 - 1] = faces[LEFT][2 - 1][3 - 1];
			faces[UP][3 - 1][1 - 1] = faces[LEFT][3 - 1][3 - 1];

			faces[LEFT][1 - 1][3 - 1] = faces[DOWN][1 - 1][1 - 1];
			faces[LEFT][2 - 1][3 - 1] = faces[DOWN][1 - 1][2 - 1];
			faces[LEFT][3 - 1][3 - 1] = faces[DOWN][1 - 1][3 - 1];

			faces[DOWN][1 - 1][3 - 1] = faces[RIGHT][1 - 1][1 - 1];
			faces[DOWN][1 - 1][2 - 1] = faces[RIGHT][2 - 1][1 - 1];
			faces[DOWN][1 - 1][1 - 1] = faces[RIGHT][3 - 1][1 - 1];

			faces[RIGHT][1 - 1][1 - 1] = temp1;
			faces[RIGHT][2 - 1][1 - 1] = temp2;
			faces[RIGHT][3 - 1][1 - 1] = temp3;

			// rotate front face
			rotateArray(FRONT,1);

			break;
		case BLUE:
			
			temp1 = faces[UP][3 - 1][1 - 1];
			temp2 = faces[UP][3 - 1][2 - 1];
			temp3 = faces[UP][3 - 1][3 - 1];

			faces[UP][3 - 1][3 - 1] = faces[LEFT][1 - 1][3 - 1];
			faces[UP][3 - 1][2 - 1] = faces[LEFT][2 - 1][3 - 1];
			faces[UP][3 - 1][1 - 1] = faces[LEFT][3 - 1][3 - 1];

			faces[LEFT][1 - 1][3 - 1] = faces[DOWN][1 - 1][1 - 1];
			faces[LEFT][2 - 1][3 - 1] = faces[DOWN][1 - 1][2 - 1];
			faces[LEFT][3 - 1][3 - 1] = faces[DOWN][1 - 1][3 - 1];

			faces[DOWN][1 - 1][3 - 1] = faces[RIGHT][1 - 1][1 - 1];
			faces[DOWN][1 - 1][2 - 1] = faces[RIGHT][2 - 1][1 - 1];
			faces[DOWN][1 - 1][1 - 1] = faces[RIGHT][3 - 1][1 - 1];

			faces[RIGHT][1 - 1][1 - 1] = temp1;
			faces[RIGHT][2 - 1][1 - 1] = temp2;
			faces[RIGHT][3 - 1][1 - 1] = temp3;

			// rotate front face
			rotateArray(FRONT,1);

			break;
		case RED:
			temp1 = faces[UP][1 - 1][3 - 1];
			temp2 = faces[UP][2 - 1][3 - 1];
			temp3 = faces[UP][3 - 1][3 - 1];

			faces[UP][1 - 1][3 - 1] = faces[FRONT][1 - 1][3 - 1];
			faces[UP][2 - 1][3 - 1] = faces[FRONT][2 - 1][3 - 1];
			faces[UP][3 - 1][3 - 1] = faces[FRONT][3 - 1][3 - 1];

			faces[FRONT][1 - 1][3 - 1] = faces[DOWN][1 - 1][3 - 1];
			faces[FRONT][2 - 1][3 - 1] = faces[DOWN][2 - 1][3 - 1];
			faces[FRONT][3 - 1][3 - 1] = faces[DOWN][3 - 1][3 - 1];

			faces[DOWN][1 - 1][3 - 1] = faces[BACK][1 - 1][3 - 1];
			faces[DOWN][2 - 1][3 - 1] = faces[BACK][2 - 1][3 - 1];
			faces[DOWN][3 - 1][3 - 1] = faces[BACK][3 - 1][3 - 1];

			// swapped right and left columns to keep orientation consistent
			faces[BACK][1 - 1][1 - 1] = temp1;
			faces[BACK][2 - 1][1 - 1] = temp2;
			faces[BACK][3 - 1][1 - 1] = temp3;
			// Rotates right column of chosen face and changes value for each
			// part of that column

			temp1 = faces[RIGHT][1 - 1][2 - 1];
			faces[RIGHT][1 - 1][2 - 1] = faces[RIGHT][2 - 1][1 - 1];
			faces[RIGHT][2 - 1][1 - 1] = faces[RIGHT][3 - 1][2 - 1];
			faces[RIGHT][3 - 1][2 - 1] = faces[RIGHT][2 - 1][3 - 1];
			faces[RIGHT][2 - 1][3 - 1] = temp1;

			temp2 = faces[RIGHT][1 - 1][1 - 1];
			faces[RIGHT][1 - 1][1 - 1] = faces[RIGHT][3 - 1][1 - 1];
			faces[RIGHT][3 - 1][1 - 1] = faces[RIGHT][3 - 1][3 - 1];
			faces[RIGHT][3 - 1][3 - 1] = faces[RIGHT][1 - 1][3 - 1];
			faces[RIGHT][1 - 1][3 - 1] = temp2;
			// Rotates face adjacent to right column
			break;
		}
	}
}
**/