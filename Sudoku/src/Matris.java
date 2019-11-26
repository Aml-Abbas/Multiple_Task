
public class Matris {
	
 private int [][] sudokuMatris;
	
	public Matris() {
		sudokuMatris =new int[9][9];
	}
	public void add(int rad, int column, int value ) {
		
		sudokuMatris[rad][column]= value;
	}
	public int get(int rad, int column) {
		
		return sudokuMatris[rad][column];
	}
	
	private boolean solve(int i, int j) {
		if(sudokuMatris[i][j]!=0) {
			int nbrToTest= get(i,j);
			nbrToTest++;
			if(nbrToTest<=9) {
				sudokuMatris[i][j]= nbrToTest;
			}else {
				solve(i-1,j);
			}
		}else {
			
		}
		return false;
	}
	
	public void clear() {
		for(int i=0; i<9;i++) {
			for(int j=0; j<9;j++) {
				sudokuMatris[i][j]=0;
			}
		}
	}
}
