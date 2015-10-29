package namtran.hust.guis.model;

public class Product {
	private String productID, productName;
	private int amount;

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductID() {
		return this.productID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

}
