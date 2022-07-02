package functionality.info;

import functionality.colorTable.impl.ForegroundPicker;

import javax.swing.*;
import java.awt.*;

/**
 * @author Erkan
 * @implNote After choosing a color from the table the shades and the picked color will appear at the bottom, granting you even more controll over the color with the JSliders.
 */
public class PickedColor extends JPanel {
	private final JLabel currColor;
	private final JSlider r, g, b;

	public PickedColor() {
		this.setLayout(null);

		currColor = new JLabel();
		currColor.setBounds(0, 10, 256, 60);
		currColor.setOpaque(true);
		currColor.setHorizontalAlignment(SwingConstants.CENTER);
		currColor.setFont(new Font("", Font.BOLD, 20));
		currColor.setVisible(true);

		r = new JSlider();
		g = new JSlider();
		b = new JSlider();

		JLabel rLabel = new JLabel();
		rLabel.setText("R: ");
		rLabel.setFont(new Font("", Font.BOLD, 30));
		rLabel.setBounds(20, 60, 70, 70);
		r.setBounds(50, 90, 180, 20);
		r.setMinimum(0);
		r.setMaximum(255);
		r.addChangeListener(e -> {
			currColor.setBackground(new Color(r.getValue(), g.getValue(), b.getValue()));
			currColor.setText("R: " + currColor.getBackground().getRed() + " G: " + currColor.getBackground().getGreen() + " B: " + currColor.getBackground().getBlue());
			currColor.setForeground(ForegroundPicker.foregroundPickerAlg(currColor.getBackground()));
		});

		JLabel gLabel = new JLabel();
		gLabel.setText("G: ");
		gLabel.setFont(new Font("", Font.BOLD, 30));
		gLabel.setBounds(15, 110, 75, 70);
		g.setBounds(50, 140, 180, 20);
		g.setMinimum(0);
		g.setMaximum(255);
		g.addChangeListener(e -> {
			currColor.setBackground(new Color(r.getValue(), g.getValue(), b.getValue()));
			currColor.setText("R: " + currColor.getBackground().getRed() + " G: " + currColor.getBackground().getGreen() + " B: " + currColor.getBackground().getBlue());
			currColor.setForeground(ForegroundPicker.foregroundPickerAlg(currColor.getBackground()));
		});

		JLabel bLabel = new JLabel();
		bLabel.setText("B: ");
		bLabel.setFont(new Font("", Font.BOLD, 30));
		bLabel.setBounds(20, 160, 70, 70);
		b.setBounds(50, 190, 180, 20);
		b.setMinimum(0);
		b.setMaximum(255);
		b.addChangeListener(e -> {
			currColor.setBackground(new Color(r.getValue(), g.getValue(), b.getValue()));
			currColor.setText("R: " + currColor.getBackground().getRed() + " G: " + currColor.getBackground().getGreen() + " B: " + currColor.getBackground().getBlue());
			currColor.setForeground(ForegroundPicker.foregroundPickerAlg(currColor.getBackground()));
		});

		this.add(currColor);
		this.add(r);
		this.add(rLabel);
		this.add(g);
		this.add(gLabel);
		this.add(b);
		this.add(bLabel);
		this.setVisible(true);
	}

	public void setLabelColor(Color color) {
		currColor.setBackground(color);
		r.setValue(color.getRed());
		g.setValue(color.getGreen());
		b.setValue(color.getBlue());
	}

	public Color getColor() {
		return currColor.getBackground();
	}
}
