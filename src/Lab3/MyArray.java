package Lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				result = i;
				break;
			}
			result = -1;
		}
		return result;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelp(target, 0);
	}

	public int recursiveLinearSearchHelp(int target, int index) {
		if (index == array.length)
			return -1;
		else if (target == array[index])
			return index;
		else
			return recursiveLinearSearchHelp(target, index + 1);
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		if (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelp(target, 0, array.length - 1);
	}

	public int recursiveBinarySearchHelp(int target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target < array[mid])
				return recursiveBinarySearchHelp(target, low, mid - 1);
			else
				return recursiveBinarySearchHelp(target, mid + 1, high);
		}
		return -1;
	}

	public static void main(String[] arags) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr1 = { 2, 9, 10, 12, 45, 50, 60 };

		MyArray a = new MyArray(arr);
		MyArray b = new MyArray(arr1);

		System.out.println(a.iterativeLinearSearch(45));
		System.out.println(a.recursiveLinearSearch(15));
		System.out.println(b.iterativeBinarySearch(12));
		System.out.println(b.recursiveBinarySearch(12));
	}
}
