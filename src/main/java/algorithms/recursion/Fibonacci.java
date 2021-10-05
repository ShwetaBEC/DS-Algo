package algorithms.recursion;

public class Fibonacci {

	public static void main(String[] args) {

		int n = 8;
		
		int fib = fibonacci(n);
		
		System.out.print(String.format("Fibonacci of %d is %d", n, fib));
	}
	
	public static int fibonacci(int n) {
		
		/*
		 * if(n == 0) { return 0; }
		 * 
		 * if(n == 1) { return 1; }
		 */
		
		if(n < 2) { // if n == 0 or n == 1
			return n;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
