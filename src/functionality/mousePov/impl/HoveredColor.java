package functionality.mousePov.impl;

import javax.swing.*;
import java.awt.*;

public class HoveredColor extends JLabel {
	public HoveredColor(int width, int height){
		this.setSize(new Dimension(width,height));
		this.setVisible(true);
		this.setOpaque(true);
	}
}
