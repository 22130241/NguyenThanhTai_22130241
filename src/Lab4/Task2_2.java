package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Task2_2 {
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int[] quickSort1(int[] array, int low, int high) {
		if (low >= high)
			return array;
		int median = getPivot_MedianOfThree(array, low, high);
		quickSort1(array, low, median - 1);
		quickSort1(array, median, high);
		return array;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = (low + high) / 2;
		int pivot = array[(low + high + mid) / 3];
		while (low <= high) {
			while (array[low] < pivot)
				low++;
			while (array[high] > pivot)
				high--;
			if (low <= high) {
				swap(array, low, high);
				low++;
				high++;
			}
		}
		return low;
	}

	public static int[] quickSort2(int[] array, int low, int high) {
		if (low < high) {
			int first = getPivot_First(array, low, high);
			quickSort2(array, low, first - 1);
			quickSort2(array, first + 1, high);
		}
		return array;
	}

	private static int getPivot_First(int[] array, int low, int high) {
		int pivot = array[low];
		int k = high;
		for (int i = high; i > low; i--) {
			if (array[i] > pivot)
				swap(array, i, k--);
		}
		swap(array, low, k);
		return k;
	}

	public static int[] quickSort3(int[] array, int low, int high) {
		if (low < high) {
			int last = getPivot_Last(array, low, high);
			quickSort3(array, low, last - 1);
			quickSort3(array, last + 1, high);
		}
		return array;
	}

	private static int getPivot_Last(int[] array, int low, int high) {
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return (i + 1);
	}

	public static int[] quickSort4(int[] array, int low, int high) {
		if (low < high) {
			int random = getPivot_Random(array, low, high);
			quickSort4(array, low, random - 1);
			quickSort4(array, random + 1, high);
		}
		return array;
	}

	private static int getPivot_Random(int[] array, int low, int high) {
		random(array, low, high);
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return i + 1;
	}

	private static void random(int array[], int low, int high) {
		Random r = new Random();
		int pivot = r.nextInt(high - low) + low;
		int temp1 = array[pivot];
		array[pivot] = array[high];
		array[high] = temp1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 23, 45, 6, 78, 5, 60 };
		int[] b = { 15, 23, 50, 6, 78, 5, 2 };
		int[] c = { 3, 23, 45, 6, 78, 5, 4 };
		int[] d = { 3, 10, 11, 6, 60, 5, 4 };

		System.out.println("Get pivot element based on the median of three strategy:");
		System.out.println(Arrays.toString(quickSort2(a, 0, a.length - 1)));

		System.out.println();

		System.out.println("Get pivot element based on the first element:");
		System.out.println(Arrays.toString(quickSort2(b, 0, b.length - 1)));

		System.out.println();

		System.out.println("Get pivot element based on the last element:");
		System.out.println(Arrays.toString(quickSort3(c, 0, c.length - 1)));

		System.out.println();

		System.out.println("Get pivot element based on choosing a randomly element:");
		System.out.println(Arrays.toString(quickSort4(d, 0, d.length - 1)));
	}
}
