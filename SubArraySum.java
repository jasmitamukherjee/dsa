// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:

// its length is at least two, and
// the sum of the elements of the subarray is a multiple of k.
// Note that:

// A subarray is a contiguous part of the array.
// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

// Example 1:

// Input: nums = [23,2,4,6,7], k = 6
// Output: true
// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
// Example 2:

// Input: nums = [23,2,6,4,7], k = 6
// Output: true
// Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
// 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// Example 3:

// Input: nums = [23,2,6,4,7], k = 13
// Output: false

import java.util.HashMap;

class SubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the first occurrence of a particular remainder
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        // Initialize with remainder 0 at index -1 to handle edge cases
        remainderMap.put(0, -1);
        
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            
            // Compute the remainder of cumulativeSum when divided by k
            int remainder = cumulativeSum % k;
            if (remainder < 0) {
                remainder += k; // handle negative remainders
            }
            
            // If this remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the index of the first occurrence of this remainder
                remainderMap.put(remainder, i);
            }
        }
        
        // If no valid subarray is found
        return false;
    }
}
