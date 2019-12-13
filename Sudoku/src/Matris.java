import java.util.Random;

public class Matris {

	private int[][] sudokuMatris;

	/** Skapar en matris med 9 rader och 9 kolumner */

	public Matris() {
		sudokuMatris = new int[9][9];
	}

	/**
	 * 
	 * Lägger till value till platsen rad, col i matrisen
	 * 
	 * @param rad raden i matrisen, column kolumnen i matrisen, value värdet som
	 *            sätts in
	 */

	public void add(int rad, int column, int value) {

		sudokuMatris[rad][column] = value;
	}

	/**
	 * returnerar värdet som finns i platsen rad,col
	 * 
	 * @return returnerar värdet i platsen rad,col
	 * @param rad raden i matrisen, column Kolumnen i matrisen
	 */

	public int get(int rad, int column) {

		return sudokuMatris[rad][column];
	}

	/**
	 * returnerar true ifall lösningen hittas annars false
	 * 
	 * @return true eller false om det finns någon lösning
	 */

	public boolean solve() {
		if (controlUser()) {
			return solve(0, 0);
		}
		return false;
	}

	/**
	 * returnera true när en lösning hittas annars false
	 * 
	 * @param rad raden i matrisen, col kolumn i matrisen
	 * @return true eller false om lösningen hittas
	 */
	private boolean solve(int rad, int col) {

		if (col == 9) {
			col = 0;
			rad++;

			if (rad == 9) {
				return true;
			}
		}
		if (sudokuMatris[rad][col] != 0) {
			return solve(rad, col + 1);
		}
		for (int value = 1; value <= 9; value++) {
			if (control(rad, col, value)) {
				sudokuMatris[rad][col] = value;
				if (solve(rad, col + 1)) {
					return true;
				}
				sudokuMatris[rad][col] = 0;
			}
		}

		return false;
	}

	/**
	 * Kontrollera ifall det är okej att lägga till ett visst värde
	 * 
	 * @param rad raden i matrisen, col kolumnen i matrisen, value värdet som sätts
	 *            in
	 * @return returnera false om value finns redan i samma rad eller kolumn eller
	 *         region
	 */

	public boolean control(int rad, int col, int value) {

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

	/**
	 * kontrollera att användaren har inte skrivit några tal som inte stämmer med
	 * reglerna
	 */
	public boolean controlUser() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (sudokuMatris[i][j] != 0) {
				
					int value = sudokuMatris[i][j];
					sudokuMatris[i][j] = 0;
					if (!control(i, j, value)) {
						return false;
					}
					sudokuMatris[i][j] = value;
				}
			}
		}

		return true;
	}

	/**
	 * tommar matrisen
	 */

	public void clear() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuMatris[i][j] = 0;
			}
		}
	}

	/** Skriver ut matrisen */

	public void print() {
		for (int i = 0; i < 9; i++) {
			System.out.println();
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + sudokuMatris[i][j]);
			}
		}
		System.out.println();
	}

	public void fillRandomly() {
		clear();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			
			int positionX = random.nextInt(9);
			int positionY = random.nextInt(9);
			int element = 1+random.nextInt(9);
			this.sudokuMatris[positionX][positionY] = element;
		}

	}
}
