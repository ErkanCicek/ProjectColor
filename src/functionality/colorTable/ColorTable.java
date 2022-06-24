package functionality.colorTable;

import functionality.colorTable.customRenderer.CustomRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ColorTable {

	private final JScrollPane scrollPane;
	private final DefaultTableModel model;
	public ColorTable(){
		//INIT
		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);
		scrollPane = new JScrollPane(table);
		model.addColumn("COLORS:");

		//CELL RENDERER
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tm = tcm.getColumn(0);
		tm.setCellRenderer(new CustomRenderer());
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void addData(String x){
		model.addRow(new Object[]{x});
	}
}
