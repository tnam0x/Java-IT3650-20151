package demo.table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class DynamicTable {

	public static void main(String[] args) {
		new DynamicTable();
	}

	public DynamicTable() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				final MyTableModel model = new MyTableModel();
				JTable table = new JTable(model);

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new JScrollPane(table));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				Timer timer = new Timer(300, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.addRow();
					}
				});
				timer.start();
			}
		});
	}

	public class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private List<String[]> rows;

		public MyTableModel() {
			rows = new ArrayList<>();
		}

		@Override
		public int getRowCount() {
			return rows.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String[] row = rows.get(rowIndex);
			return row[columnIndex];
		}

		public void addRow() {
			int rowCount = getRowCount();
			String[] row = new String[getColumnCount()];
			for (int index = 0; index < getColumnCount(); index++) {
				row[index] = rowCount + "x" + index;
			}
			rows.add(row);
			fireTableRowsInserted(rowCount, rowCount);
		}
	}
}
