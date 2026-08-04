/*
Problem: Count Good Numbers
Platform: LeetCode (1922)

Approach:
1. A good number has:
   - Even indices: digits {0, 2, 4, 6, 8}  -> 5 choices
   - Odd indices:  digits {2, 3, 5, 7}     -> 4 choices

2. Count positions:
   - even = (n + 1) / 2
   - odd  = n / 2

3. Total good numbers:
      5^even * 4^odd

4. Since n can be very large, compute powers using
   Fast Exponentiation (Binary Exponentiation) under modulo 1e9 + 7.

5. Combine both results and take modulo.

Time Complexity: O(log n)
Space Complexity: O(log n)   // Due to recursion stack

Optimization:
- An iterative binary exponentiation can reduce the auxiliary
  space to O(1).
*/

class Solution {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % mod;

        return (int) ans;
    }

    public long power(long x, long y) {
        if (y == 0)
            return 1;

        long half = power(x, y / 2);
        long ans = (half * half) % mod;

        if (y % 2 == 1)
            ans = (ans * x) % mod;

        return ans;
    }
}
