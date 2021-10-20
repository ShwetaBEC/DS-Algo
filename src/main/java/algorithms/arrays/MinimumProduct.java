package algorithms.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumProduct {

	public static void main(String[] args) {

		Integer arr[] = {198, 76, 544, 123, 154, 675};
		List<Integer> a = Arrays.asList(arr);
        int k = 2;
        System.out.print("Minimum product is " +
                          product(a, k));
	}
	
	private static int product(List<Integer> arr, int k) {
		
		int product = 1;
		int count = 0;
		
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(arr);		

		while(!p.isEmpty() && count < k) {
			product *= p.poll();
			count++;
		}
		
		return product;
	}

}
