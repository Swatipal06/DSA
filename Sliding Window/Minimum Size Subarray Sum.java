/*
Problem: Minimum Size Subarray Sum
Platform: LeetCode (209)

Approach:
1. Use the Sliding Window technique because all numbers are positive.
2. Maintain:
   - left: Start of the window.
   - right: End of the window.
   - curSum: Sum of elements in the current window.
3. Expand the window by moving right and adding nums[right].
4. While the current sum is greater than or equal to the target:
   - Update the minimum window length.
   - Shrink the window from the left by subtracting nums[left].
5. If no valid subarray is found, return 0.

Why does this work?
- Since all elements are positive, increasing the window can only
  increase the sum, and shrinking the window can only decrease it.
- This allows a linear-time two-pointer solution.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];

            while (curSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                curSum -= nums[left];
                left++;
            }
        }
        
        return minLen != Integer.MAX_VALUE ? minLen : 0;        
    }
}
