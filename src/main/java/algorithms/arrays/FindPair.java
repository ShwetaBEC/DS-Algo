package algorithms.arrays;

import java.util.HashSet;

public class FindPair {

	public static void main(String[] args){

        int[] arr1 = {1, 2, 3, 9, 10};
        int[] arr2 = {1, 2, 3, 4, 4};
        int sum = 8;

        boolean hasPair = hasPair(arr1, sum);
        System.out.println(hasPair);

        hasPair = hasPairInSortedArray(arr1, sum);
        System.out.println(hasPair);
        
        hasPair = hasPairInUnsortedArray(arr2, sum);
        System.out.println(hasPair);
    }

	//Brute force - O(n^2)
    static boolean hasPair(int[] arr1, int sum){
        
    	for(int i=0; i < arr1.length-1; i++){
            for (int j=i+1; j < arr1.length; j++){
                if(arr1[i]+arr1[j] == sum){
                    return true;
                }
            }
        }
        return false;
    }

    //Efficient way - O(n)
    static boolean hasPairInSortedArray(int[] arr1, int sum){
    	
    	int i = 0, j=arr1.length-1;
    	while(i < j) {
    		int tempSum = arr1[i] + arr1[j];
    		if(tempSum == sum) {
    			return true;
    		}
    		
    		if(tempSum < sum) {
    			i++;
    		}else {
    			j--;
    		}
    	}
    	
    	return false;
    }
    
  //Efficient way for unsorted array - O(n)
    static boolean hasPairInUnsortedArray(int arr1[], int sum) {
    	
    	HashSet<Integer> complimentsSet = new HashSet<Integer>();
    	
    	for(int i = 0; i< arr1.length; i++) {
    		if(complimentsSet.contains(arr1[i])) {
    			return true;
    		}
    		
    		complimentsSet.add(sum-arr1[i]);
    	}
    	
    	return false;
    }

}
