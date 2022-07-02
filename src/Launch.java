import functionality.colorTable.ColorTable;
import functionality.info.PickedColor;
import functionality.mousePov.ZoomOnMouse;
import functionality.mousePov.impl.HoveredColor;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Launch {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 6, Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
		mainPanel.setLayout(null);

		//init the zoom on mouse with hovered-color
		HoveredColor hoveredColor = new HoveredColor(frame.getWidth(), 40);
		ZoomOnMouse zoomOnMouse = new ZoomOnMouse(frame.getWidth(), frame.getWidth(), hoveredColor);
		zoomOnMouse.setBounds(0, 0, frame.getWidth(), frame.getWidth());
		hoveredColor.setBounds(0, frame.getWidth() + 5, frame.getWidth(), 40);


		//Info init
		PickedColor pickedColor = new PickedColor();
		pickedColor.setBounds(0, 530, 256, 822 - 520);


		//Init table and choosen color
		JLabel[] colorShade = new JLabel[5];
		JPanel colorShadesPanel = new JPanel();
		colorShadesPanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
		colorShadesPanel.setLayout(new GridLayout(1, 5, 0, 0));

		//init the labels
		for (int i = 0; i < colorShade.length; i++) {
			JLabel label = new JLabel();
			label.setOpaque(true);
			label.setVisible(true);
			colorShade[i] = label;
			colorShadesPanel.add(label);
		}

		colorShadesPanel.setBounds(0, 470, 256, 50);
		colorShadesPanel.setVisible(true);

		ColorTable colorTable = new ColorTable(colorShade, pickedColor);
		colorTable.getScrollPane().setBounds(0, 310, frame.getWidth(), 150);


		//Add componets here
		mainPanel.add(pickedColor);
		mainPanel.add(colorTable.getScrollPane());
		mainPanel.add(colorShadesPanel);
		mainPanel.add(hoveredColor);
		mainPanel.add(zoomOnMouse);


		mainPanel.setVisible(true);
		frame.add(mainPanel);
		frame.setVisible(true);

		//keybinders
		InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK, false), "chooseColor");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.ALT_DOWN_MASK, false), "copyRgb");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK, false), "copyHex");

		ActionMap actionMap = mainPanel.getActionMap();
		actionMap.put("chooseColor", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Robot robot = new Robot();
					PointerInfo pointerInfo = MouseInfo.getPointerInfo();
					Point point = pointerInfo.getLocation();

					Color capturedColor = robot.getPixelColor(point.x, point.y);
					String dataOfCapturedColor = capturedColor.getRed() + "," + capturedColor.getGreen() + "," + capturedColor.getBlue();
					colorTable.addData(dataOfCapturedColor);
				} catch (AWTException ex) {
					ex.printStackTrace();
				}

			}
		});

		actionMap.put("copyRgb", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = pickedColor.getColor();
				String dataToBeCopied = "RGB: " + color.getRed() + "," + color.getGreen() + "," + color.getBlue();
				StringSelection selection = new StringSelection(dataToBeCopied);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
			}
		});

		actionMap.put("copyHex", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = pickedColor.getColor();
				StringSelection selection = new StringSelection(
						String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue())
				);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
			}
		});

	}
}
