/*
Problem: Second Largest Digit in a String
Platform: LeetCode (1796)

Approach:
1. Traverse the string and consider only characters that are digits.
2. Convert each digit character into its integer value.
3. Maintain two variables:
   - `max` = largest digit found so far.
   - `secMax` = second largest distinct digit found so far.
4. If the current digit is greater than `max`:
   - Move the current `max` to `secMax`.
   - Update `max` with the current digit.
5. Otherwise, if the current digit is smaller than `max` but greater
   than `secMax`, update `secMax`.
6. Return `secMax`. It remains `-1` if there is no second distinct digit.

Key Idea:
Maintain the largest and second largest distinct digits in a single
pass instead of sorting the digits.

The condition `val != max` ensures that duplicate occurrences of the
largest digit are not considered as the second largest digit.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int secondHighest(String s) {
        int n = s.length();

        int max = -1;
        int secMax = -1;

        char[] ch = s.toCharArray();

        for(int i=0; i<n; i++) {
            if(ch[i] >= '0' && ch[i] <= '9') {
                int val = (ch[i] - '0');

                if(val > max) {
                    secMax = max;
                    max = val;
                } else if(secMax < val && val != max) {
                    secMax = val;
                }
            }
        }

        return secMax;
    }
}
