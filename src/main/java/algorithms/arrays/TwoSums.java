package algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSums {

	
	/**
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	You can return the answer in any order.
	
	
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int []arr = {2,7,11,15};
		int [] indices = twoSum(arr, 9);
		
		System.out.print(indices);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        
        int []num = new int[2];
        
        for(int i=0; i< nums.length; i++){
            
            if(set.get(target-nums[i]) == null){
                set.put(nums[i], i);
            }else{
                num[0] = set.get(target-nums[i]);
                num[1] = i;
                break;
            }
        }
        return num;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        
        Set<Integer> set = new HashSet<Integer>();
        
        Set<String> strSet = new HashSet<String>();
                
        List<Integer> triplet = null;
                
        int temp;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
     
        
        for(int i = 0; i< nums.length-1; i++){
                        
            int tempSum = 0 - nums[i];
            
            set = new HashSet<Integer>();
            
            for(int j = i+1; j< nums.length; j++){
                
                    if((set.contains(tempSum - nums[j])) &&
                            (!strSet.contains(nums[i]+":"+nums[j]+":"+(tempSum - nums[j])))){
                    
                        triplet = new ArrayList<Integer>();
                    
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(tempSum - nums[j]);
                        
                        l.add(triplet);
                        strSet.add(nums[i]+":"+nums[j]+":"+(tempSum - nums[j]));
                  
                    }
                    set.add(nums[j]);                      
                }
            }       
        return l;
    }
}
