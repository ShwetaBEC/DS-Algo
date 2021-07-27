package algorithms.arrays;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,7,11,15};
        int sum = 9;
        
        int[] indexarray = getPairIndices(arr1, sum);
        System.out.print("["+indexarray[0]+ ","+ indexarray[1]+ "]");
	}
	
	//Efficient way O(n) and extra space like Map. Using Brute force O(n^2) can also be done.
	static int[] getPairIndices(int arr[], int sum) {
		
        int indexarray [] = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< arr.length; i++) {
        	
        	if(map.containsKey(sum - arr[i])) {
        		indexarray[0] = map.get(sum-arr[i]);
        		indexarray[1] = i;
        		break;
        	}
        	
        	map.put(arr[i], i);
        }
        return indexarray;
	}

}
