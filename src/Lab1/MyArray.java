package Lab1;

import java.util.Arrays;

public class MyArray {
	int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[array.length * 2 - 1 - i] = array[i];
		}
		return result;
	}

	public int[] removeDuplicates() {
		int count = 0;
		boolean isDuplicate;
		int[] arr = new int[this.array.length];
		for (int i = 0; i < arr.length; i++) {
			isDuplicate = false;
			for (int j = 0; j < count; j++) {
				if (arr[j] == this.array[i]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				arr[count] = this.array[i];
				count++;
			}
		}
		int[] result = new int[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr[i];
		}
		return result;

	}

	public int[] getMissingValues() {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] == array[i] + 1) {
				count++;
			}
		}
		int[] result = new int[array.length - count - 1];

		for (int i = 0; i < array.length - count - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j + 1] != array[j] + 1) {
					result[i] = array[j] + 1;
					i++;
				}
			}
		}

		return result;
	}

	public int[] fillMissingValues(int k) {
		int[] result = array;
		for (int i = 1; i < result.length - 1; i++) {
			if (result[i] < result[i - 1]) {
				result[i] = (result[i - 1] + result[i + 1] + result[i + 2]) / k;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] arr1 = { 1, 3, 5, 1, 3, 7, 8, 9 };
		int[] arr2 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] arr3 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };

		MyArray a = new MyArray(arr);
		MyArray b = new MyArray(arr1);
		MyArray c = new MyArray(arr2);
		MyArray d = new MyArray(arr3);

		int[] missvalue = c.getMissingValues();
		int[] re = a.mirror();
		int[] remove = b.removeDuplicates();
		int[] fillmissvalue = d.fillMissingValues(3);

		System.out.println(Arrays.toString(re));
		System.out.println(Arrays.toString(remove));
		System.out.println(Arrays.toString(missvalue));
		System.out.println(Arrays.toString(fillmissvalue));
	}
}
