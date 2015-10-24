package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import namtran.hust.guis.interfaces.IProduct;
import namtran.hust.guis.interfaces.IProductList;

public class ProductList implements IProductList {
	private IProduct[] iProduct;
	private Product product;
	private int numbersOfProduct = -1;

	public ProductList() {
		try (BufferedReader reader = new BufferedReader(new FileReader("product list.txt"))) {
			String line;
			StringTokenizer readData;
			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, "|");
				while (readData.hasMoreTokens()) {
					product.setProductID(readData.nextToken());
					product.setProductID(readData.nextToken());
					product.setAmount(Integer.parseInt(readData.nextToken()));
					iProduct[++numbersOfProduct] = product;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public IProduct[] getIProduct() {
		return iProduct;
	}

}
