/*
Problem: Power of Three
Platform: LeetCode (326)

Approach:
1. Handle edge cases:
   - If n <= 0, it cannot be a power of three.
   - If n == 1, return true because 3^0 = 1.

2. For other values:
   - A number is a power of three if it is divisible by 3
     and the quotient is also a power of three.

3. Recursively divide n by 3 until reaching 1 or a number
   that is not divisible by 3.

Example:
27 -> 9 -> 3 -> 1  => true
45 -> 15 -> 5      => false

Time Complexity: O(log₃ n)
Space Complexity: O(log₃ n)   // Recursion stack
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        int x;
        if(n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return (n % 3 == 0 && isPowerOfThree(n / 3));
    }
}
