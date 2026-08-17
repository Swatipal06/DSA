/*
Problem: Minimum Size Subarray Sum
Platform: LeetCode (209)

Approach:
1. Use Binary Search on the answer (subarray length).
2. For a given length `size`, check whether there exists a subarray
   of exactly that length whose sum is at least `target`.
3. The `isPossible()` method uses a Sliding Window:
   - Maintain a window of size `size`.
   - Calculate the sum of each window.
   - Track the maximum window sum.
   - If the maximum sum is >= target, the length is feasible.
4. Since all numbers are positive, if a particular length is possible,
   every larger length is also considered possible, allowing Binary Search.
5. Binary Search for the minimum feasible subarray length.

Time Complexity: O(n log n)
Space Complexity: O(1)

Note:
- This solution uses Binary Search + Sliding Window.
- A direct Sliding Window solution can solve the same problem in O(n).
*/

class Solution {
    public boolean isPossible(int size, int[] nums, int target) {
        int sum = 0;
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        while(j < n) {
            sum += nums[j];

            if(j-i+1 == size) {
                max = Math.max(sum, max);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if(max >= target) {
            return true;
        }
        return false;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = n;

        int min = 0;

        while(l <= r) {
            int mid = (l + r) / 2;

            if (isPossible(mid, nums, target)) {
                r = mid-1;
                min = mid; 
            } else {
                l = mid + 1;
            }
        }
        return min;
    }
}
