
public class Matris {

	private int[][] sudokuMatris;

	public Matris() {
		sudokuMatris = new int[9][9];
	}

	public void add(int rad, int column, int value) {

		sudokuMatris[rad][column] = value;
	}

	public int get(int rad, int column) {

		return sudokuMatris[rad][column];
	}

	public boolean solve() {
		
	return solve(0,0);
	}
	private boolean solve(int rad, int col) {
		if(col==9) {
			col=0;
			rad++;
		
		if(rad==9) {
			return true;
		}
		}
		if(sudokuMatris[rad][col]!=0) {
			return solve(rad,col+1);
		}
		for(int value = 1; value <= 9; value++) {
			if(control(rad,col,value)) {
				sudokuMatris[rad][col]=value;
				if(solve(rad,col+1)) {
					return true;
				}
				sudokuMatris[rad][col]=0;
			}
		}
		return false;
	}

	private boolean control(int rad, int col, int value) {

		// kontrollera raden
		for (int j = 0; j < sudokuMatris.length; j++) {
			if (sudokuMatris[rad][j] == value) {
				return false;
			}

		}
		// kontrollera column
		for (int i = 0; i < 9; i++) {
			if (sudokuMatris[i][col] == value) {
				return false;
			}
		}

		// kontrollera region
		int r = rad - rad % 3;
		int c = col - col % 3;
		for (int k = r; k < r + 3; k++) {
			for (int m = c; m < c + 3; m++) {
				if (sudokuMatris[k][m] == value) {
					return false;
				}
			}
		}
		return true;
	}

	public void clear() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuMatris[i][j] = 0;
			}
		}
	}

	public void print() {
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + sudokuMatris[i][j]);
			}
		}
	}
}
