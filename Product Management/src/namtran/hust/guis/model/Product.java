package namtran.hust.guis.model;

import namtran.hust.guis.interfaces.IProduct;

public class Product implements IProduct {
	private String productID, productName;
	private int amount;

	@Override
	public void setProductID(String productID) {
		this.productID = productID;
	}

	@Override
	public String getProductID() {
		return this.productID;
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int getAmount() {
		return this.amount;
	}

}
