
public class Methods {
	
	public int[][] solve(int[][] sudoku) {
		int i = 0;
		int j = 0;
		int count = 0;
		int lastNum = 0;
		
		while (i < 9) {
			while (j < 9) {
				count = 0;
				if (sudoku[i][j] == 0) {
					for (int num = 1; num < 10; num++) {
						if (checkBox(sudoku, i, j, num) && checkHorizontalVertical(sudoku, i, j, num)) {
							count++;
							lastNum = num;
						}
					}
				}
				if (count == 1) {
					sudoku[i][j] = lastNum;
					i = 0;
					j = -1;
				}
				j++;
			}
			j = 0;
			i++;
		}
		return sudoku;
	}
	

	public boolean checkHorizontalVertical(int[][] sudoku, int x, int y, int num) {
		boolean vertical = true;
		boolean horizontal = true;

		for (int i = 0; i < 9; i++) {
			if (num == sudoku[i][y]) {
				horizontal = false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (num == sudoku[x][i]) {
				vertical = false;
			}
		}
		return vertical && horizontal;
	}
	

	public boolean checkBox(int[][] sudoku, int x, int y, int num) {
		int k = 0;
		int startx = x / 3 * 3;
		int starty = y / 3 * 3;
		int[] box = new int[9];

		for (int j = starty; j <= starty + 2; j++) {
			for (int i = startx; i <= startx + 2; i++) {
				box[k] = sudoku[i][j];
				k++;
			}
		}
		for (int i = 0; i < box.length; i++) {
			if (num == box[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[][] deepCopy(int[][] array) {
		int[][] methodArray = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				methodArray[i][j] = array[i][j];
			}
		}

		return methodArray;
	}

}
