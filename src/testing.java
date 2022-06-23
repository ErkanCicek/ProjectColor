import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class testing {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		model.addColumn("COLORS");
		model.addRow(new Object[]{"255,0,0"});
		model.addRow(new Object[]{"0,255,0"});
		model.addRow(new Object[]{"0,0,255"});
		JScrollPane scrollPane = new JScrollPane(table);

		TableColumnModel tcm = table.getColumnModel();
		TableColumn tm = tcm.getColumn(0);
		tm.setCellRenderer(new Renderer());

		frame.add(scrollPane);
		frame.setVisible(true);
	}
}

class Renderer extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(CENTER);
		String tempString = (String) table.getValueAt(row, column);
		String[]test = tempString.split(",");

		Color color = new Color(
				Integer.parseInt(test[0]),
				Integer.parseInt(test[1]),
				Integer.parseInt(test[2])
		);

		setBackground(color);

		super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);

		return this;
	}
}



