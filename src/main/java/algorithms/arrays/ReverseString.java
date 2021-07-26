package algorithms.arrays;

public class ReverseString {

	public static void main(String[] args) {
		
		String str = "Hi, I am Shweta";
		
		System.out.println(String.format("Actual string %s", str));
		System.out.println(String.format("Reversed String using manual reverse %s ", reverseString(str)));
		System.out.print("");
	}
	
	private static String reverseString(String str) {
		
		if(str == null || str.length()<2) {
			return "Not a valid string to reverse";
		}
		
		int totalItems = str.length() - 1;
		
		char[] actualString = str.toCharArray();
		char[] reversedString = new char[totalItems+1];
		
		int j = 0;
		for(int i=totalItems; i>=0; i--, j++) {
			reversedString[j] = actualString[i];
		}
				
		return String.valueOf(reversedString);
	}
	
	

}
