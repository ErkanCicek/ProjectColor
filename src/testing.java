import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class testing {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,700);


		DefaultTableModel model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable table = new JTable(model);
		model.addColumn("COLORS");
		model.addRow(new Object[]{"hi"});
		model.addRow(new Object[]{"ok"});


		TableColumn column;
		myRenderer renderer = new myRenderer();
		column = table.getColumnModel().getColumn(0);
		column.setCellRenderer(renderer);


		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane);

		frame.setVisible(true);

		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		if (x == 1){
			renderer.setColor(Color.blue);
			model.addRow(new Object[]{"NICE"});
		}
	}
}

class myRenderer extends DefaultTableCellRenderer{
	Color bg, fg;
	public myRenderer() {
		super();
		this.bg = Color.green;
		this.fg = Color.black;
	}
	public Component getTableCellRendererComponent(JTable table, Object
			value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		Component cell = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		cell.setBackground(bg);
		cell.setForeground(fg);
		return cell;
	}

	public void setColor(Color color){
		this.bg = color;
	}
}

