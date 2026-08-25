/*
Problem: Length of Last Word
Platform: LeetCode (58)

Approach:
1. Remove trailing and leading spaces using `trim()`.
2. Start traversing the string from the last character.
3. Count characters until a space is encountered after finding at
   least one character.
4. Once a space is found, the last word has ended, so stop the loop.
5. Return the count of characters in the last word.

Key Idea:
Start from the end of the string because the required word is the
last word. Count characters until the first space is encountered.

Time Complexity: O(n)
Space Complexity: O(n) due to `trim()` creating a new string
*/


class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else if (length > 0) {
                break;
            }
        }
        
        return length;
    }
}
