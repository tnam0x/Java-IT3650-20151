package namtran.hust.interfaces;

public class MainScreen {
	final static int MAX_SELLABLE = 100;
	private static Sellable[] sellAble;
	private static double cost;

	public static void main(String[] args) {
		sellAble = new Sellable[MAX_SELLABLE];
		int i = 0;
		Item item = new Item("1234567890123", "Large Orange Screwdriver", 55.55);
		sellAble[i++] = item;
		Timber timber = new Timber("Treated Pine", 18, 4, 3.25, 11);
		sellAble[i++] = timber;
		item = new Item("12312312", "Self Sealing Stem Bolts", 0.99);
		sellAble[i++] = item;
		item = new Item("P100000000000", "White & Flattener Corded D", 123);
		sellAble[i++] = item;
		timber = new Timber("Shellacked Wind", 2.8, 2.8, 12, 4);
		sellAble[i++] = timber;
		Rock rock = new Rock("Limestone", 212.5, 2);
		sellAble[i++] = rock;
		rock = new Rock("Medium Volcanic Rocks", 8.5, 6.6);
		sellAble[i++] = rock;

		for (int j = 0; j < i; j++) {
			System.out.println(sellAble[j].getReceiptLine());
			cost += sellAble[j].getPrice();
		}
		// show cost
		String str = "Total $" + cost;
		System.out.format("%51s", str);
	}

}
