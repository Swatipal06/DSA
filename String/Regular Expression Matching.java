/*
Problem: Regular Expression Matching
Platform: LeetCode (10)

Approach:
1. Use Recursion to compare the string `s` with the pattern `p`.
2. At each position, check whether the current characters match:
   - Characters are equal, or
   - Pattern character is `.`.
3. If the next pattern character is `*`, there are two choices:
   - Skip the current pattern character and `*`:
       `check(i, j + 2, ...)`
     This means `*` matches zero occurrences.
   - If the current characters match, use `*` to match the current
     character and stay at the same pattern position:
       `check(i + 1, j, ...)`
4. If there is no `*`:
   - When characters match, move both pointers forward.
   - Otherwise, return false.
5. When the entire pattern is processed, return true only if the
   entire string has also been processed.

Key Idea:
The `*` operator gives two possibilities:
- Match zero occurrences of the previous character.
- Match one or more occurrences and continue matching.

The recursion explores both possibilities to determine whether the
entire string matches the pattern.

Time Complexity: O(2^(n+m)) in the worst case
Space Complexity: O(n+m) due to recursion stack
*/

class Solution {
     public boolean check(int i, int j, int n, int m, String s, String p) {
        if(j == m) {
            return i == n;
        }

        boolean match = (i < n) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j + 1 < m && p.charAt(j + 1) == '*') {
            return check(i, j + 2, n, m, s, p) || (match && check(i + 1, j, n, m, s, p));
        } else {
            if(match) {
                return check(i + 1, j + 1, n, m, s, p);
            }
            return false;
        }
    }

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        return check(0, 0, n, m, s, p);
    }
}
