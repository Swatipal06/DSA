/*
Problem: Add Binary
Platform: LeetCode (67)

Approach:
1. Use two pointers `i` and `j` starting from the last characters
   of strings `a` and `b`.
2. Maintain a carry `c` for the binary addition.
3. Traverse both strings from right to left:
   - Add the current digit from `a` if available.
   - Add the current digit from `b` if available.
   - Add the carry from the previous calculation.
4. The resulting binary digit is `sum % 2`.
5. Update the carry using `sum / 2`.
6. Continue while there are digits left in either string or a carry
   remains.
7. Since digits are generated from right to left, reverse the
   `StringBuilder` before returning the result.

Key Idea:
Perform binary addition from right to left just like normal addition,
while handling different string lengths and the carry separately.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, c = 0;

        while (i >= 0 || j >= 0 || c == 1) {
            int sum = c;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            res.append(sum % 2);
            c = sum / 2;
        }

        return res.reverse().toString();
    }
}
