public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		
		
		/* CROSS PIECES */
		TextIO.putln(Cube.toString(false));
		ScanCrossPieces.run();
		TextIO.putln(Cube.toString(true));

	}

}
