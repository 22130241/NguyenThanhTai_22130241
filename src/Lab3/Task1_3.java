package Lab3;

public class Task1_3 {
	private int[] array;

	public Task1_3(int[] array) {
		this.array = array;
	}

	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target > array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelp(target, 0, array.length - 1);
	}

	public int recursiveBinarySearchHelp(int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target > array[mid])
				return recursiveBinarySearchHelp(target, low, mid - 1);
			else
				return recursiveBinarySearchHelp(target, mid + 1, high);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 60, 50, 45, 12, 10, 9, 2 };
		Task1_3 a = new Task1_3(arr);

		System.out.println(a.iterativeBinarySearch(4));
		System.out.println(a.recursiveBinarySearch(60));
	}
}
