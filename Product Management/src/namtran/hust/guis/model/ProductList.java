package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ProductList {
	private ArrayList<Product> proList;
	private Product product;

	public ProductList() {
		readData(null);
	}

	public ProductList(String url) {
		readData(url);
	}

	public void readData(String url) {
		if (url == null)
			url = "src\\product list.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
			String line;
			StringTokenizer readData;
			proList = new ArrayList<Product>();

			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, "|");
				while (readData.hasMoreTokens()) {
					product = new Product();
					product.setProductID(readData.nextToken());
					product.setProductName(readData.nextToken());
					product.setAmount(Integer.parseInt(readData.nextToken()));
					proList.add(product);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), e, "File error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Product> getProduct() {
		return proList;
	}

}
