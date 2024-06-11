// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

// Example 1:

// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]
// Example 2:

// Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
// Output: [22,28,8,6,17,44]

import java.util.*;

class ArraySort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Create a frequency map for arr1
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Iterate over arr2 and collect elements in the order specified by arr2
        int index = 0;
        for (int num : arr2) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                arr1[index++] = num;
            }
            // Remove the element from the map after processing
            frequencyMap.remove(num);
        }

        // Step 3: Collect remaining elements and sort them
        List<Integer> remainingElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remainingElements.add(num);
            }
        }
        Collections.sort(remainingElements);

        // Step 4: Combine the results
        for (int num : remainingElements) {
            arr1[index++] = num;
        }

        return arr1;
    }
}
