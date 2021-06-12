import javax.swing.*;
import java.awt.*;

public class Solution extends JComponent {
	int[][] sudoku = new int[9][9];
	int[][] initial = new int[9][9];
	final int x0 = 390;
	final int y0 = 50;
	final int width = 8;
	final int length = 675;
	final int dis = 75;
	final int numSize = 25;
	long time = 0;
	int nums = 0;
	String dif = "";

	public Solution(int[][] sudoku,int[][] initial,long time,int nums) {
		JFrame frame = new JFrame("Solution");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.add(this);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.sudoku = sudoku;
		this.initial=initial;
		this.time = time;
		this.nums = nums;
	}

	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		//Create Board
		int count = 0;
		gr.fillRect(x0, y0, width, length);
		gr.fillRect(x0, y0, length, width);
		gr.fillRect(x0, y0 + length, length, width);
		gr.fillRect(x0 + length, y0, width, length + width);

		for (int i = y0 + dis; i < (y0 + length); i += dis) {
			if (count < 2) {
				gr.fillRect(x0, i, length, 2);
				count++;
			} else {
				gr.fillRect(x0, i, length, 5);
				count = 0;
			}
		}
		count = 0;
		for (int i = x0 + dis; i < (x0 + length); i += dis) {
			if (count < 2) {
				gr.fillRect(i, y0, 2, length);
				count++;
			} else {
				gr.fillRect(i, y0, 5, length);
				count = 0;
			}
		}
		//Insert numbers 
		gr.setFont(new Font ("SansSerif",Font.PLAIN,numSize));
		gr.setColor(Color.RED);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9;j++) {				
				
				gr.drawString(sudoku[i][j]+"", (x0 + (i+1)*dis)-dis/2-width, (y0 + (j+1)*dis)-dis/2+width);
			}			
		}
		gr.setColor(Color.BLACK);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9;j++) {
				if(initial[i][j]!=0) {
					gr.drawString(initial[i][j]+"", (x0 + (i+1)*dis)-dis/2-width, (y0 + (j+1)*dis)-dis/2+width);}
			}			
		}
		
		gr.drawString("Completed in : " + (double)time/1000+" secs", 1100, 300);
		
		
		
		if(nums >= 32) {
			dif = "Easy";
		}
		else if( nums >= 27) {
			dif = "Medium";
		}		
		else if( nums >= 24) {
			dif = "Hard";
		}
		else {
			dif = "Very Hard";
		}

		gr.drawString("Numbers given  : " + nums+" | "+dif, 1100, 200);
	}

}
