package Lab4;

import java.util.Arrays;

public class Task1 {
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static int[] selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] < array[j]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
		return array;
	}

	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] < array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
		return array;
	}

	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int n = array[i];
			int j = i;
			while (j > 0 && array[j - 1] < n) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = n;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 7, 9 };
		int[] arr1 = { 6, 3, 8, 1, 10 };
		int[] arr2 = { 10, 3, 2, 5, 9 };

		System.out.println("Mang sau khi dung selectionSort la:");
		System.out.println(Arrays.toString(selectionSort(arr)));

		System.out.println();

		System.out.println("Mang sau khi dung bubbleSort la:");
		System.out.println(Arrays.toString(bubbleSort(arr1)));

		System.out.println();

		System.out.println("Mang sau khi dung insertionSort la:");
		System.out.println(Arrays.toString(insertionSort(arr2)));
	}

}
