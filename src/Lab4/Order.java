package Lab4;

import Lab3.OrderItem;
import Lab3.Product;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	private static void swap(OrderItem[] items, int i, int j) {
		OrderItem tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}

	public OrderItem[] bubleSortProductById(OrderItem[] items) {
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].getP().getId().compareTo(items[j + 1].getP().getId()) > 0) {
					swap(items, j, j + i);
				}
			}
		}
		return items;
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
		m.bubleSortProductById(items);
		System.out.println("Danh sach san pham sau khi dung Bubble sort la: ");
		for (OrderItem item : items) {
			System.out.println(item);
		}
	}
}
