// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the value and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current element
            int complement = target - nums[i];
            
            // Check if the complement exists in the hashmap
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the current element and the complement
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current element and its index to the hashmap
            map.put(nums[i], i);
        }
        
        // If no solution is found, throw an exception (according to the problem statement, there is always exactly one solution)
        throw new IllegalArgumentException("No two sum solution");
    }
}
