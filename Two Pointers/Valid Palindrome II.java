/*
Problem: Valid Palindrome II
Platform: LeetCode (680)

Approach:
1. Use the Two Pointer approach with `l` at the beginning and `r`
   at the end of the string.
2. Compare characters from both ends:
   - If they match, move both pointers inward.
   - If they do not match, we are allowed to delete at most one
     character.
3. At the first mismatch, check both possibilities:
   - Skip the character at `l` and check `l + 1` to `r`.
   - Skip the character at `r` and check `l` to `r - 1`.
4. If either remaining substring is a palindrome, return true.
5. If no mismatch occurs, the original string is already a palindrome.

Key Two Pointer Idea:
At the first mismatch, there are only two possible characters that
can be removed: the left character or the right character.

Checking both possibilities ensures that at most one deletion is used.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }  

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
