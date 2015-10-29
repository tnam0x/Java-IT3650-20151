package namtran.hust.guis.controller;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import namtran.hust.guis.model.Product;
import namtran.hust.guis.model.ProductList;

public class DisplayProductController extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ProductList productList;
	private int NUMBERS_OF_ROW;
	private final String[] columnNames = { "Product ID", "Product name", "Amount" };
	private Object[][] data;

	public DisplayProductController(String url) {
		if (url == null)
			productList = new ProductList();
		else
			productList = new ProductList(url);
		initializeData();
	}

	public void initializeData() {
		NUMBERS_OF_ROW = productList.getProduct().size();
		data = new Object[NUMBERS_OF_ROW][3];
		ArrayList<Product> product = productList.getProduct();
		for (int i = 0; i < NUMBERS_OF_ROW; i++) {
			Product p = product.get(i);
			data[i][0] = p.getProductID();
			data[i][1] = p.getProductName();
			data[i][2] = p.getAmount();
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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
	}
}
