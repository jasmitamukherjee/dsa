

import java.util.HashMap;

class LongestString {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the last index of each character
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // If the character is already in the hashmap and its index is within the current window
            if (charIndexMap.containsKey(currentChar)) {
                // Move the start pointer to the right of the last occurrence of the current character
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            
            // Update the last index of the current character
            charIndexMap.put(currentChar, end);
            
            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
