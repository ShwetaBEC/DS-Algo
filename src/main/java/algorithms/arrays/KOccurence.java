package algorithms.arrays;

public class KOccurence {

	public static void main(String[] args) {
		
		System.out.println("First statement");
		int arr[] = {1, 2, 3, 3, 5};
		
		
		/**
		 * li - 0, hi - 4, mi - 2, arr[mi] - 3
		 * li - 0, hi - 2, mi - 1, arr[mi] - 2
		 * li - 0, hi - 1, mi - 0, arr[mi] - 1
		 * li - 0, hi - 0, mi - 0, fo - 0, 
		 * 
		 * 
		 * li - 0, hi - 4, mi - 2, arr[mi] - 3
		 * li - 2, hi - 4, mi - 3, arr[3] - 3
		 * li - 3, hi - 4, mi - 3, arr[3] - 3
		 * 
		 * 
		 */
		
		int k = 5;
		
		int li = 0, hi = arr.length-1;
		int mi = (li + hi)/2;
		int fo = -1;
		
		while(li <= hi) {
			if(k == arr[mi]) {
				hi = mi;
				fo = mi;
			}else if( k < arr[mi]) {
				hi = mi - 1;
			}else {
				li = mi + 1;
			}
			mi = (li + hi)/2;
		}
		
		System.out.print(String.format("First occurance is %d", fo));
		
	}

}
