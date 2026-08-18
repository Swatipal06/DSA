/*
Problem: Valid Parenthesis String
Platform: LeetCode (678)

Approach:
1. Use a Greedy approach with two counters:
   - `minCnt` = minimum possible number of unmatched opening brackets.
   - `maxCnt` = maximum possible number of unmatched opening brackets.
2. Traverse the string character by character:
   - For '(':
       Both `minCnt` and `maxCnt` increase by 1.
   - For ')':
       Both `minCnt` and `maxCnt` decrease by 1.
   - For '*':
       It can act as '(', ')' or an empty string:
       `minCnt--` and `maxCnt++`.
3. If `minCnt` becomes negative, reset it to 0 because `*` can
   potentially be treated as an empty string or ')'.
4. If `maxCnt` becomes negative, return false because there are more
   closing brackets than can possibly be matched.
5. After processing the entire string, return true only if
   `minCnt == 0`, meaning a valid arrangement is possible.

Key Greedy Idea:
Maintain a range `[minCnt, maxCnt]` representing all possible numbers
of unmatched opening brackets after processing each character.

The `*` character provides flexibility by allowing the range to expand
or shrink.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minCnt = 0, maxCnt = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == ')') {
                minCnt--;
                maxCnt--;
            } else if(s.charAt(i) == '(') {
                minCnt++;
                maxCnt++;
            } else {
                minCnt--;
                maxCnt++;
            }

            if(minCnt < 0) {
                minCnt = 0;
            }
            if(maxCnt < 0) {
                return false;
            }
        }
        return minCnt == 0;
    }
}
