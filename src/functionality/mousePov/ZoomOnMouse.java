package functionality.mousePov;

import functionality.colorTable.impl.ForegroundPicker;
import functionality.mousePov.impl.HoveredColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * @author Erkan
 * @implNote shows the user where their mouse is pointing in a buffered image which reloads live
 */
public class ZoomOnMouse extends JLabel {
	private final BufferedImage mousePerspective;

	public ZoomOnMouse(int width, int height, HoveredColor hoveredColor) {
		mousePerspective = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.setIcon(new ImageIcon(mousePerspective));
		this.setVisible(true);


		Robot robot;
		try {
			robot = new Robot();
			Runnable runnable = () -> {
				ActionListener actionListener = e -> {
					PointerInfo pointerInfo = MouseInfo.getPointerInfo();
					Point point = pointerInfo.getLocation();
					BufferedImage tempMousePerspective = robot.createScreenCapture(new Rectangle(
							point.x - (width / 4), point.y - (height / 4), (width / 2), (height / 2)
					));
					Graphics graphics = mousePerspective.getGraphics();
					graphics.drawImage(tempMousePerspective, 0, 0, width, height, null);
					graphics.fillRect(height / 2, 0, 2, height);
					graphics.fillRect(0, width / 2, width, 2);
					graphics.dispose();
					Color hoveredOverColor = robot.getPixelColor(point.x, point.y);
					hoveredColor.setText(
							"R:" + hoveredOverColor.getRed() + "  G:" + hoveredOverColor.getGreen() + "  B:" + hoveredOverColor.getBlue()
					);

					hoveredColor.setForeground(ForegroundPicker.foregroundPickerAlg(hoveredOverColor));
					hoveredColor.setBackground(hoveredOverColor);
					this.repaint();
				};
				Timer timer = new Timer(10, actionListener);
				timer.start();
			};
			SwingUtilities.invokeLater(runnable);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
