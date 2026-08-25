/*
Problem: Wildcard Matching
Platform: LeetCode (44)

Approach:
1. Use a Greedy approach with two pointers:
   - `si` = current index in string `s`.
   - `pi` = current index in pattern `p`.
2. If the current pattern character:
   - Matches the current string character, or
   - Is `?`
   then move both pointers forward.
3. If the pattern character is `*`:
   - Store its position in `star`.
   - Store the current string position in `com`.
   - Move the pattern pointer forward and initially let `*` match
     zero characters.
4. If a mismatch occurs and a previous `*` exists:
   - Backtrack to the character after `*`.
   - Let `*` match one more character by incrementing `com`.
   - Continue matching from there.
5. If there is a mismatch and no previous `*` exists, return false.
6. After processing the string, skip any remaining `*` characters
   in the pattern.
7. Return true only if the entire pattern has been processed.

Key Greedy Idea:
Treat `*` as matching the minimum number of characters initially.
When a mismatch occurs, expand the `*` to match one additional
character and retry.

This avoids recursive backtracking and solves the problem using
constant extra space.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, com = 0, star = -1;
        int n = s.length(), m = p.length();

        while(si < n) {
            if(pi < m && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
                si++;
                pi++;
            } else if(pi < m && p.charAt(pi) == '*') {
                star = pi;
                com = si;
                pi++;
            } else if(star != -1) {
                pi = star + 1;
                com++;
                si = com;
            } else {
                return false;
            }
        }
        while(pi < m && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == m;
    }
}
