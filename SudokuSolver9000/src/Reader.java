import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
	int[][] sudoku = new int[9][9];

	public int[][] read() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Sudoku.txt"));
			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(";");				
				sudoku[Integer.parseInt(arr[0])-1][Integer.parseInt(arr[1])-1] = Integer.parseInt(arr[2]);
				line = br.readLine();
			}
			
			return sudoku;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	public String toString() {
		String sudokuString = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuString+=("x : "+(i+1) + " | y : " +  (j+1) + " | value : " +sudoku[i][j] +"\n" );				
			}			
		}
		
		return sudokuString;
	}
}
