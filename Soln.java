

class Result1 {

	public static long f(long n) {
		long sum = 0;
		char[] arr = String.valueOf(n).toCharArray();
		for (char c : arr) {
			sum += factorial(Integer.parseInt(String.valueOf(c)));
		}
		return sum;
	}

	public static long factorial(long arg) {
		while (arg > 1) {
			return (long) arg * factorial(arg - 1);
		}
		return 1;
	}

	public static long sf(long n) {
		long sum = 0l;
		long x = f(n);
		char[] arr = String.valueOf(x).toCharArray();
		for (char c : arr) {
			sum += Integer.parseInt(String.valueOf(c));
		}
		return sum;
	}

	public static long g(long i) {
		long value = 0;
		while (sf(value) != i) {
			value++;
		}
		return value;
	}

	public static long sg(long i) {
		long sum = 0;
		long x = g(i);
		char[] arr = String.valueOf(x).toCharArray();
		for (char c : arr) {
			sum += Integer.parseInt(String.valueOf(c));
		}
		return sum;
	}

	public static long zigma(int n, int m) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += sg(i);
		}
		return sum % m;
	}

}

public class Soln {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		System.out.println(Result1.g(46));
	}
}