/*
Problem: Reverse String
Platform: LeetCode (344)

Approach:
1. Use the Two Pointer approach.
2. Initialize:
   - `l` at the beginning of the array.
   - `r` at the end of the array.
3. While `l < r`:
   - Swap the characters at `l` and `r`.
   - Move `l` one step forward.
   - Move `r` one step backward.
4. Continue until the two pointers meet.
5. The array is reversed in-place.

Key Two Pointer Idea:
Swap the characters from both ends and move towards the center.
This reverses the string without using an extra array.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}
