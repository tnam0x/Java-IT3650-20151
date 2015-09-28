package namtran.hust.interfaces;

public class MainScreen {
	final static int MAX_SELLABLE = 10;
	private static Sellable[] sa = new Sellable[MAX_SELLABLE];
	private static double cost;

	public static void main(String[] args) {
		Item item = new Item("1234567890123", "Large Orange Screwdriver", 55.55);
		sa[0] = item;
		Timber timber = new Timber("Treated Pine", 18, 4, 3.25, 11);
		sa[1] = timber;
		item = new Item("12312312", "Self Sealing Stem Bolts", 0.99);
		sa[2] = item;
		item = new Item("P100000000000", "White & Flattener Corded D", 123);
		sa[3] = item;
		timber = new Timber("Shellacked Wind", 2.8, 2.8, 12, 4);
		sa[4] = timber;

		for (int i = 0; i < 5; i++) {
			System.out.println(sa[i].getReceiptLine());
			cost += sa[i].getPrice();
		}
		System.out.format("%1$45s $%2$-7.2f", "Total", cost);
	}

}
