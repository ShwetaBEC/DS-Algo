package algorithms.recursion;

public class Factorial {

	public static void main(String[] args) {
		
		int num = 5;
		
		int fact = fact(num);
		System.out.print(String.format("Fact of %d is %d",num, fact));

	}
	
	public static int fact(int num) {
		if(num == 2) {
			return 2;
		}
		
		return num * fact(num - 1);
	}
}
