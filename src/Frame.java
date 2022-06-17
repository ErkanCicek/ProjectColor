import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
	public Frame(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dimension.width/6, dimension.height-20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
