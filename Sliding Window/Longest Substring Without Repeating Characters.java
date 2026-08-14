/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode (3)

Approach:
1. Use the Sliding Window technique with two pointers.
2. Maintain a HashMap to store the frequency of characters
   present in the current window.
3. Expand the right pointer and include the current character.
4. If a character appears more than once:
   - Shrink the window from the left.
   - Decrease the frequency of characters until all characters
     in the window become unique again.
5. Update the maximum window length during the traversal.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            
            while (count.get(c) > 1) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;       
    }
}
