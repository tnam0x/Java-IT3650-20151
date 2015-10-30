package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ProductList {
	private ArrayList<Product> productList;
	private Product product;

	public ProductList() {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("product list.txt");
		readData(input);
	}

	public ProductList(String filePath) throws FileNotFoundException {
		InputStream input = new FileInputStream(filePath);
		readData(input);
	}

	public void readData(InputStream input) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			String line;
			StringTokenizer readData;
			productList = new ArrayList<Product>();

			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, "|ï»¿");

				while (readData.hasMoreTokens()) {
					product = new Product();

					product.setProductID(readData.nextToken());
					product.setProductName(readData.nextToken());
					product.setAmount(Integer.parseInt(readData.nextToken()));
					productList.add(product);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), e, "File error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

	public ArrayList<Product> getProduct() {
		return productList;
	}

}
