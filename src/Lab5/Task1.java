package Lab5;

public class Task1 {
	public static int[][] add(int[][] a, int[][] b) {
		int row;
		int col;
		int[][] result = new int[a.length][a[0].length];
		;
		if (a.length != b.length || a[0].length != b[0].length)
			System.out.println("Khong thoa man dieu kien !");
		else {
			for (row = 0; row < result.length; row++) {
				for (col = 0; col < result[row].length; col++) {
					result[row][col] = a[row][col] + b[row][col];
				}

			}
			printArray(result);
		}
		return result;
	}

	public static int[][] subtract(int[][] a, int[][] b) {
		int row;
		int col;
		int[][] result = new int[a.length][a[0].length];
		if (a.length != b.length || a[0].length != b[0].length)
			System.out.println("Khong thoa man dieu kien !");
		else {
			for (row = 0; row < result.length; row++) {
				for (col = 0; col < result[row].length; col++) {
					result[row][col] = a[row][col] - b[row][col];
				}
			}
			printArray(result);
		}
		return result;
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int row;
		int col;
		int[][] result = new int[a.length][b[0].length];
		if (a[0].length != b.length)
			System.out.println("Khong thoa man dieu kien !");
		else {
			for (row = 0; row < result.length; row++) {
				for (col = 0; col < result[row].length; col++) {
					result[row][col] += a[row][col] * b[col][row];
				}
			}
			printArray(result);
		}
		return result;
	}

	public static int[][] transpose(int[][] a) {
		int row = 0;
		int col;
		int[][] result = new int[a[0].length][a.length];
		for (row = 0; row < result.length; row++) {
			for (col = 0; col < result[row].length; col++) {
				result[row][col] = a[col][row];
			}
		}
		return result;
	}

	public static void printArray(int[][] array) {
		int row;
		int col;
		for (row = 0; row < array.length; row++) {
			for (col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "\t");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] b = { { 0, 3, 3 }, { 1, 2, 3 } };
		int[][] c = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Ma tran tong la:");
		add(a, b);

		System.out.println();

		System.out.println("Ma tran hieu la:");
		subtract(a, b);

		System.out.println();

		System.out.println("Ma tran tich la:");
		multiply(a, c);

		System.out.println();

		System.out.println("Ma tran chuyen vi la:");
		printArray(transpose(c));
	}
}
