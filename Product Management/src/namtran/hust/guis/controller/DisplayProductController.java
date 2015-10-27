package namtran.hust.guis.controller;

import javax.swing.table.AbstractTableModel;

import namtran.hust.guis.model.ProductList;

public class DisplayProductController extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ProductList proList;
	private int NUMBERS_OF_ROW;
	private final String[] columnNames = { "Product ID", "Product name", "Amount" };
	private Object[][] data;

	public DisplayProductController() {
		proList = new ProductList();
		readData();
	}

	public DisplayProductController(String url) {
		proList = new ProductList(url);
		readData();
	}

	public void readData() {
		NUMBERS_OF_ROW = proList.getProduct().size();
		data = new Object[NUMBERS_OF_ROW][3];
		for (int i = 0; i < NUMBERS_OF_ROW; i++) {
			data[i][0] = proList.getProduct().get(i).getProductID();
			data[i][1] = proList.getProduct().get(i).getProductName();
			data[i][2] = proList.getProduct().get(i).getAmount();
		}
	}

	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public void fireTableDataChanged() {
		
	}
}
