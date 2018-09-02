import java.util.ArrayList;

public class States {
	Methods m = new Methods();

	public ArrayList<int[][]> CreateChildren(int[][] father) {
		int x = -1;
		int y = -1;
		ArrayList<int[][]> children = new ArrayList<>();
		int[][] child = m.deepCopy(father);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (child[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
			if (x != -1) {
				break;
			}
		}

		for (int i = 1; i < 10; i++) {
			if (m.checkBox(child, x, y, i) && m.checkHorizontalVertical(child, x, y, i)) {
				child[x][y] = i;
				children.add(m.solve(child));
				child = new int[9][9];
				child = m.deepCopy(father);
			}
		}

		return children;
	}

}
