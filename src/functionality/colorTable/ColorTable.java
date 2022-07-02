package functionality.colorTable;

import functionality.colorTable.impl.ColorShades;
import functionality.colorTable.impl.CustomRenderer;
import functionality.info.PickedColor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

/**
 * @author Erkan
 * @implNote ColorTable is a Jtable that create new rows based on the color you choose, if you want to scroll through the list. Simply put your mouse on the table and scrole with the middle mouse button.
 */
public class ColorTable {
	private final JScrollPane scrollPane;
	private final DefaultTableModel model;

	public ColorTable(JLabel[] labels, PickedColor pickedColor) {
		//INIT
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //row are not editable
			}
		};
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false); //makes the table static on frame
		scrollPane = new JScrollPane(table);


		model.addColumn("COLORS:");
		model.addRow(new Object[]{"255,0,0"});
		model.addRow(new Object[]{"0,255,0"});
		model.addRow(new Object[]{"0,0,255"});

		//CELL RENDERER - giving cells colur based on value
		table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());

		//Event handler
		table.getSelectionModel().addListSelectionListener(e -> {
			String selectedData;
			selectedData = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);

			String[] rgb = selectedData.split(",");
			Color color = new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
			Color[] colorShades = new Color[labels.length];
			Arrays.fill(colorShades, color);

			pickedColor.setLabelColor(color);

			ColorShades.getColorShades(colorShades, colorShades.length);
			for (int i = 0; i < labels.length; i++) {
				labels[i].setBackground(colorShades[i]);
			}
		});
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void addData(String data){
		model.addRow(new Object[]{data});
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
}
