package namtran.hust.interfaces;

import java.text.DecimalFormat;

public class Rock implements Sellable, HasMass {
	private String description;
	private double pricePerCubicMetres; // price
	private double buyVolume; // amount buy (m3)

	public Rock(String description, double pricePerCubicMetres, double buyVolume) {
		this.description = description;
		this.pricePerCubicMetres = pricePerCubicMetres;
		this.buyVolume = buyVolume;
	}

	public String toString() {
		String str = "Buy volume: " + buyVolume + " | Price/CubicMetres: " + pricePerCubicMetres + " | Description: "
				+ description;
		return str;
	}

	@Override
	public double getVolume() {
		return buyVolume;
	}

	@Override
	public double getPrice() {
		return pricePerCubicMetres * buyVolume;
	}

	@Override
	public String getReceiptLine() {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = buyVolume + " cubic metres of " + description;
		return String.format("%1$-41s $ %2$7s", str, df.format(getPrice()));
	}

}
