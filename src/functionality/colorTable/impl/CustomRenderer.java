package functionality.colorTable.impl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author Erkan
 * @implNote Custom renderer for my table
 */
public class CustomRenderer extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (table.getRowCount() != 0) {
			setHorizontalAlignment(CENTER);
			String tempString = (String) table.getValueAt(row, column);
			String[]test = tempString.split(",");

			Color color = new Color(
					Integer.parseInt(test[0]),
					Integer.parseInt(test[1]),
					Integer.parseInt(test[2])
			);

			Color foregroundColor = ForegroundPicker.foregroundPickerAlg(color);
			setForeground(foregroundColor);

			setBackground(color);
		}

		super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);

		return this;
	}
}
