package Lab2;

public class Fibonacci {
	public static int getFibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int f_n1 = getFibonacci(n - 1);
		int f_n2 = getFibonacci(n - 2);
		return f_n1 + f_n2;
	}

	public static void printFibonacci(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		System.out.println(getFibonacci(5));
		printFibonacci(5);
	}
}
