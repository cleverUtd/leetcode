public class FibonacciNumber {

	public static int fib_recursive(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;

		return fib_recursive(N - 1) + fib_recursive(N - 2);
	}

	public static int fib(int N) {
		if (N <= 1)
			return N;

		int f1 = 1, f2 = 0;
		int sum = 0;
		while (N-- > 1) {
			sum = f1 + f2;
			f2 = f1;
			f1 = sum;
		}
		return sum;
	}


	public static void main(String[] args) {
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
	}
}
