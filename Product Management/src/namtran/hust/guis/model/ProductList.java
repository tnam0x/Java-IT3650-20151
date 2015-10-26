package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import namtran.hust.guis.interfaces.IProductList;

public class ProductList implements IProductList {
	private ArrayList<Product> proList;
	private Product product;

	public ProductList() {
		readData(null);
	}
	
	public ProductList(String url) {
		readData(url);
	}

	public void readData(String url) {
		if(url == null)
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
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Product> getProduct() {
		return proList;
	}

}
