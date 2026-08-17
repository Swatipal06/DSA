/*
Problem: Valid Perfect Square
Platform: LeetCode (367)

Approach:
1. Use Binary Search to determine whether there exists an integer
   whose square is equal to `num`.
2. Search in the range [0, num].
3. For each middle value:
   - Calculate mid².
   - If mid² == num, return true.
   - If mid² > num, search the left half.
   - If mid² < num, search the right half.
4. Use `long` for the square calculation to prevent integer overflow.
5. If the search space becomes empty, no perfect square root exists.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            long square = (long) mid * mid;
            if(square == num) {
                return true;
            } else if(square > num) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}
