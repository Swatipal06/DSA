/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode (3)

Approach:
1. Use the Sliding Window technique with two pointers.
2. Maintain a HashMap to store the frequency of characters
   in the current window.
3. Expand the right pointer and add characters to the window.
4. If a duplicate character is found:
   - Move the left pointer forward.
   - Decrease the frequency of characters until the window
     contains unique characters again.
5. Track the maximum window length during the traversal.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0;
        int maxLen = 0;

        Map<Character, Integer> cnt = new HashMap<>();

        for(int r=0; r<n; r++) {
            char ch = s.charAt(r);

            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);

            while(cnt.get(ch) > 1) {
                char leftChar = s.charAt(l);
                cnt.put(leftChar, cnt.get(leftChar) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
