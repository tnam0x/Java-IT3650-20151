package namtran.hust.interfaces;

import java.text.DecimalFormat;

public class Item implements Sellable {
	private String barcode, description;
	private double price;

	public Item(String barcode, String description, double price) {
		this.barcode = barcode;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		String str = "Price: " + price + " | Description: " + description + " | Barcode: " + barcode;
		return str;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getReceiptLine() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format("%1$13s: %2$-26s $ %3$7s", barcode, description, df.format(price));
	}

	@Override
	public double getVolume() {
		return 0;
	}
}
