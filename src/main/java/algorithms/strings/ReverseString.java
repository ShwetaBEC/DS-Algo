package algorithms.strings;

public class ReverseString {
	
	static String revStr = "";
	
	public static void main(String[] args) {
		
		String str = "abcz";
		
		String reversedString = reverse(str, 0);
		
		System.out.print(revStr);

	}
	
	public static String reverse(String str, int n) {
		
		if(n == (str.length() - 1)) {
			return String.valueOf(str.charAt(n-1));
		}
		
		revStr = revStr + reverse(str, n+1);
			
		return String.valueOf(str.charAt(n));
		
		
	}

}
