package namtran.hust.interfaces;

public interface Sellable extends HasMass{
	// to print receipt
	public double getPrice();
	public String getReceiptLine();
}
