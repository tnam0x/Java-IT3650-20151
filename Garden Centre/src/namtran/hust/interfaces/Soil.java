package namtran.hust.interfaces;

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
		// TODO Auto-generated method stub
		return null;
	}
}
