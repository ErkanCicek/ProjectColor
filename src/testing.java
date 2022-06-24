import functionality.colorTable.ColorTable;

import javax.swing.*;
import java.util.Scanner;

public class testing {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		ColorTable colorTable = new ColorTable();
		frame.add(colorTable.getScrollPane());

		frame.setVisible(true);

		int x = new Scanner(System.in).nextInt();
		if (x == 1){
			colorTable.addData("127,255,0");
		}
	}
}




