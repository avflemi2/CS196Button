public class ScanCrossPieces extends Scanner {

	private static int[] pairs = { 4, 7, 13, 16, 22, 25, 31, 34 };

	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];

	// run the method
	public static void run() {
		setFlags();
		if (sameFaces() == 4)
			return; // faces are aligned
		alignBottom();
		if (isAdjacent()) {
			Cube.setOrientation(orientAdjacent());
			Algorithms.swapCrossPieces(1);
		} else {
			Cube.setOrientation(orientOpposite());
			Algorithms.swapCrossPieces(2);
		}
	}

	private static void setFlags() {
		for (int i = 0, j = 0; i < pairs.length-1; i += 2, j++) {
			flags[j] = equals(pairs[i], pairs[i + 1]);
		}
	}

	// returns number of faces that have pairs
	private static int sameFaces() {
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	private static void alignBottom() {
		while (sameFaces() < 2) {
			Algorithms.swapCrossPieces(3);
		}
	}

	// returns face that will set orientation
	private static int orientAdjacent() {
		if (flags[0] && flags[3])
			return 3;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	private static boolean isAdjacent() {
		for (int i = 0; i < flags.length - 1; i++) {
			if (flags[i] && flags[i + 1])
				return true;
		}
		return false;
	}

	public static int orientOpposite() {
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}
}