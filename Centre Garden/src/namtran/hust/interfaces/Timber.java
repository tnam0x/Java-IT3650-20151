package namtran.hust.interfaces;

import java.text.DecimalFormat;

public class Timber implements Sellable {
	private String typeOfWood;
	private double thickness, width, legth, pricePerMeter;

	/*
	 * đơn vị các chiều dày, rộng, dài là cm
	 */
	public Timber(String typeOfWood, double thickness, double width, double legth, double costPerMeter) {
		this.typeOfWood = typeOfWood;
		this.thickness = thickness;
		this.width = width;
		this.legth = legth;
		this.pricePerMeter = costPerMeter;
	}

	@Override
	public String toString() {
		String str = "Type of wood: " + typeOfWood + " | Thickness: " + thickness + " | Width: " + width + " | Legth: "
				+ legth + " | Price/Meter: " + pricePerMeter;
		return str;
	}

	@Override
	public double getPrice() {
		return legth * pricePerMeter;
	}

	@Override
	public String getReceiptLine() {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = legth + " m of " + width + " cm x " + thickness + " cm " + typeOfWood;
		return String.format("%1$-41s $ %2$7s", str, df.format(getPrice()));
	}

	@Override
	public double getVolume() {
		return 0;
	}
}
