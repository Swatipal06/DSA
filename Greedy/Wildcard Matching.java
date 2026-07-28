/*
Problem: Wildcard Matching
Platform: LeetCode (44)

Approach:
1. Use the Greedy Two Pointer technique with backtracking support.
2. Maintain:
   - si: Current index in the string.
   - pi: Current index in the pattern.
   - star: Latest position of '*' in the pattern.
   - com: Position in the string where matching after '*' started.
3. Traverse the string:
   - If characters match or pattern has '?', move both pointers forward.
   - If pattern has '*', store its position and move the pattern pointer.
   - If a mismatch occurs but a previous '*' exists:
       - Assume '*' matches one more character from the string.
       - Move string pointer forward and retry from after '*'.
   - If no '*' is available, the match fails.
4. After processing the string, skip remaining '*' characters.
5. The pattern matches only if the entire pattern is consumed.

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
