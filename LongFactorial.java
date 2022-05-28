

import java.math.BigInteger;

public class LongFactorial {
	public static void main(String[] args) {
		BigInteger temp1 = BigInteger.valueOf(-1);
		BigInteger temp2 = BigInteger.valueOf(-1);
		System.out.println(temp1.equals(temp2));
		extraLongFactorials(5);
	}

	public static void extraLongFactorials(long n) {
		// Write your code here
		BigInteger N = BigInteger.valueOf(n);
		N = factorial(N);
	}

	public static BigInteger factorial(BigInteger a) {
		while (!a.equals(BigInteger.valueOf(1))) {
			BigInteger temp = a.add(BigInteger.valueOf(-1));
			return multiply(a, factorial(temp));
		}
		return BigInteger.valueOf(1);
	}

	public static BigInteger multiply(BigInteger a, BigInteger b) {
		BigInteger c = BigInteger.valueOf(0);
		for (BigInteger i = BigInteger.valueOf(1); i.equals(b); i = i.add(BigInteger.valueOf(1))) {
			c = a.add(a);
		}

		return c;
	}

}
