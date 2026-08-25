/*
Problem: Longest Palindromic Substring
Platform: LeetCode (5)

Approach:
1. Use the Expand Around Center approach.
2. Every palindrome has a center:
   - For odd-length palindromes, the center is a single character.
   - For even-length palindromes, the center lies between two characters.
3. For every index `i`:
   - Expand from `(i, i)` to find the longest odd-length palindrome.
   - Expand from `(i, i + 1)` to find the longest even-length palindrome.
4. The `expand()` function keeps moving `left` and `right` outward
   while:
   - Both indices remain within the string.
   - Characters at both ends are equal.
5. After expansion stops, return the substring between `left + 1`
   and `right`.
6. Keep track of the longest palindrome found and return it.

Key Idea:
Instead of checking every possible substring, treat each character
(or gap between two characters) as a possible center and expand
outward to find a palindrome.

Both odd and even length palindromes must be checked.

Time Complexity: O(n²)
Space Complexity: O(n)
*/

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if (s == null || n < 2) {
            return s;
        }

        String ans = "";

        for (int i = 0; i < n; i++) {

            String odd = expand(s, i, i);
            if (odd.length() > ans.length()) {
                ans = odd;
            }
            
            String even = expand(s, i, i + 1);
            if (even.length() > ans.length()) {
                ans = even;
            }
        }
        return ans;
    }

    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
