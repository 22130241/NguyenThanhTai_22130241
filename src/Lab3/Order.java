package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double result = 0.0;
		for (OrderItem item : items) {
			double price = item.getP().getPrice();
			int quality = item.getQuality();
			result += price * quality;
		}
		return result;
	}

	public void sortProductById(OrderItem[] items) {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {

				return o1.getP().getId().compareTo(o2.getP().getId());
			}

		});

	}

	// using binary search approach
	public boolean contains(Product p) {
		sortProductById(items);
		int low = 0;
		int high = items.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (p.getId().compareTo(items[mid].getP().getId()) == 0) {
				return true;
			} else if (p.getId().compareTo(items[mid].getP().getId()) < 0) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return false;
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		int count = 0;
		for (OrderItem item : items) {
			if (type.compareTo(item.getP().getType()) == 0) {
				count++;
			}
		}
		Product[] p = new Product[count];
		int n = 0;
		for (OrderItem item : items) {
			if (type.compareTo(item.getP().getType()) == 0) {
				p[n] = item.getP();
				n++;
			}
		}
		return p;
	}

	public static void main(String[] args) {
		Product p = new Product("002", "Coca", 10000, "lon");
		Product p1 = new Product("001", "Pepsi", 15000, "lon");
		Product p2 = new Product("003", "Hao Hao", 6000, "ly");

		OrderItem o = new OrderItem(p, 2);
		OrderItem o1 = new OrderItem(p1, 1);
		OrderItem o2 = new OrderItem(p2, 3);

		OrderItem[] items = new OrderItem[3];
		items[0] = o;
		items[1] = o1;
		items[2] = o2;

		Order m = new Order(items);

		System.out.println("Danh sach san pham da mua la: ");
		for (OrderItem item : items) {
			System.out.println(item);
		}
		System.out.println();

		m.sortProductById(items);
		System.out.println("Danh sach san pham sau khi sap xep la: ");
		for (OrderItem item : items) {
			System.out.println(item);
		}
		System.out.println();

		System.out.println("So tien phai thanh toan la: " + m.cost());
		System.out.println();

		System.out.println("San pham lon la: ");
		Product[] product = m.filter("lon");
		for (Product pro : product) {
			System.out.println(pro);
		}
		System.out.println();
		System.out.println(m.contains(p2));
	}
}
