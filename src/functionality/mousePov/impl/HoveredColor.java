package functionality.mousePov.impl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Erkan
 * @implNote background is changed based on where the mouse is pointed.
 */
public class HoveredColor extends JLabel {
	public HoveredColor(int width, int height){
		this.setSize(new Dimension(width,height));
		this.setVisible(true);
		this.setHorizontalAlignment(CENTER);
		this.setOpaque(true);
	}
}
