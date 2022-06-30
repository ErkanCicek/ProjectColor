package functionality.colorTable;

import functionality.colorTable.impl.CustomRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ColorTable {

	private final JScrollPane scrollPane;
	private final DefaultTableModel model;
	public ColorTable(){
		//INIT
		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //row are not editable
			}
		};
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false); //makes the table static on frame
		scrollPane = new JScrollPane(table);
		model.addColumn("COLORS:");
		model.addRow(new Object[]{"22,22,100"
		});

		//CELL RENDERER - giving cells colur based on value
		table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());

		//Event handler
		table.getSelectionModel().addListSelectionListener(e -> {
			String selectedData;
			selectedData = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
			String[]rgb = selectedData.split(",");
					Color color = new Color(
					Integer.parseInt(rgb[0]),
					Integer.parseInt(rgb[1]),
					Integer.parseInt(rgb[2])
			);



		});
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void addData(String data){
		model.addRow(new Object[]{data});
	}


}
