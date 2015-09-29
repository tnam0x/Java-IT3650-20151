package namtran.hust.interfaces;

import java.text.DecimalFormat;

public class MainScreen {
	final static int MAX_SELLABLE = 100;
	private static Sellable[] sellable;
	private static double cost;
	private static double totalVolume;

	public static void main(String[] args) {
		sellable = new Sellable[MAX_SELLABLE];
		int i = 0;
		// add sellable
		Item item = new Item("1234567890123", "Large Orange Screwdriver", 55.55);
		sellable[i++] = item;
		Timber timber = new Timber("Treated Pine", 18, 4, 3.25, 11);
		sellable[i++] = timber;
		item = new Item("12312312", "Self Sealing Stem Bolts", 0.99);
		sellable[i++] = item;
		item = new Item("P100000000000", "White & Flattener Corded D", 123);
		sellable[i++] = item;
		timber = new Timber("Shellacked Wind", 2.8, 2.8, 12, 4);
		sellable[i++] = timber;
		Rock rock = new Rock("Limestone", 212.5, 2);
		sellable[i++] = rock;
		rock = new Rock("Medium Volcanic Rocks", 8.5, 6.6);
		sellable[i++] = rock;
		Soil soil = new Soil("Loam", 30, 12.25, 10);
		sellable[i++] = soil;
		soil = new Soil("River Sand", 40, 2.2, 2.4);
		sellable[i++] = soil;
		// display
		for (int j = 0; j < i; j++) {
			System.out.println(sellable[j].getReceiptLine());
			cost += sellable[j].getPrice();
		}
		// show cost
		DecimalFormat df = new DecimalFormat(".##");
		String str = "Total $" + df.format(cost);
		System.out.println("---------------------------------------------------");
		System.out.format("%51s", str);
		System.out.println("\nVolume in delivery: " + totalVolume + " cubic metres");

	}

}
