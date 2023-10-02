package Lab2;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n <= 0)
			return 0;
		return (int) ((Math.pow(-1, n + 1) * n) + getSn1(--n));
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1)
			return 1;
		return factorial(n) + getSn2(--n);
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(--n);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n <= 0)
			return 0;
		return (int) (Math.pow(n, 2) + getSn3(--n));
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n <= 0)
			return 1;
		return (1 / (double) getSn4Helper(n)) + getSn2(--n);
	}

	public static int getSn4Helper(int n) {
		if (n == 0)
			return 1;
		return n * 2 * getSn4Helper(--n);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(2));
		System.out.println(getSn2(4));
		System.out.println(getSn3(4));
		System.out.println(getSn4(2));
	}
}
