package namtran.hust.interfaces;

import java.text.DecimalFormat;

public class Soil implements Sellable, HasMass {
	private String description;
	private double pricePerCubicMetres; // price
	private double buyVolume; // amount buy (m3)
	private double particleSize; // mm

	public Soil(String description, double pricePerCubicMetres, double buyVolume, double particleSize) {
		this.description = description;
		this.pricePerCubicMetres = pricePerCubicMetres;
		this.buyVolume = buyVolume;
		this.particleSize = particleSize;
	}

	@Override
	public double getVolume() {
		return buyVolume;
	}

	@Override
	public double getPrice() {
		return buyVolume * pricePerCubicMetres;
	}

	@Override
	public String getReceiptLine() {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = buyVolume + " cubic metres of " + description+" ("+particleSize+")";
		return String.format("%1$-41s $ %2$7s", str, df.format(getPrice()));
	}
}
