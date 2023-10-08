package Lab3;

public class OrderItem {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}

	public Product getP() {
		return p;
	}

	public int getQuality() {
		return quality;
	}

	@Override
	public String toString() {
		return "Product: " + p + ", quality: " + quality;
	}

}
