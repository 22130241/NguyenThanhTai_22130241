package Lab4;

import java.util.Arrays;

public class Task2_1 {
	public static int[] mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, high);
		}
		return array;
	}

	public static void merge(int[] array, int low, int high) {
		int[] temp = new int[array.length];
		int i;
		int mid = (low + high) / 2;
		int a = low;
		int b = mid + 1;
		for (i = low; a <= mid && b <= high; i++) {
			if (array[a] >= array[b]) {
				temp[i] = array[a++];
			} else if (array[b] >= array[a]) {
				temp[i] = array[b++];
			}
		}
		while (a <= mid) {
			temp[i++] = array[a++];
		}
		while (b <= high) {
			temp[i++] = array[b++];
		}
		for (i = low; i <= high; i++) {
			array[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 40, 50, 11, 12, 20, 23 };
		System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	}
}
