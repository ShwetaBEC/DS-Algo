package algorithms.recursion;

public class CalculatePowewr {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 9;
		
		int power = calculatePow(a, b);
		
		if( (b%2) == 1) {
			power = a * power;
		}
		System.out.print(String.format("a^b is %d", power));
	}
	
	private static int calculatePow(int a, int b) {
		if(b == 0 | b == 1) {
			return a;
		}
		int val = calculatePow(a, b/2);
		return val * val;
	}
}
