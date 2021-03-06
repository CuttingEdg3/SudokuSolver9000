import java.util.ArrayList;
import java.util.Iterator;

public class main {
	public static void main(String args[]) {

		
		Reader rd = new Reader();
		Methods m = new Methods();
		States s = new States();
		ArrayList<int[][]> ai = new ArrayList<>();
		int solNum = -1;

		rd.read();
		
		int nums = rd.nums;
		
		long startTime = System.currentTimeMillis();

		int[][] sudoku = m.solve(m.deepCopy(rd.sudoku));
		
		if (!isFinal(sudoku)) {
			ai.add(sudoku);
			while (true) {
				
				ai.addAll(s.CreateChildren(ai.get(0)));
				ai.remove(0);
				
				for (int i = 0; i < ai.size(); i++) {
					if(isFinal(ai.get(i))) {
						solNum = i;
						break;
					}					
				}
				if(solNum!=-1) {
					long stopTime = System.currentTimeMillis();
				    long elapsedTime = stopTime - startTime;
					Solution sol = new Solution(ai.get(solNum), rd.sudoku,elapsedTime,nums);
					break;
				}			
			}

		} else {
			Solution sol = new Solution(sudoku, rd.sudoku,- startTime + System.currentTimeMillis(),nums );
		}
	}

	public static boolean isFinal(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
