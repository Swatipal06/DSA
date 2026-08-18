/*
Problem: Split Array Largest Sum
Platform: LeetCode (410)

Approach:
1. Use Binary Search on Answer to find the minimum possible largest
   subarray sum.
2. Set the search range:
   - `l` = maximum element in the array, because every subarray must
     contain its elements without splitting an individual element.
   - `r` = total sum of the array, representing one subarray.
3. For each `mid`, use the `check()` function to determine whether the
   array can be split into at most `k` subarrays such that the sum of
   every subarray is <= `mid`.
4. In `check()`:
   - Keep adding elements to the current subarray while the sum
     remains <= `mid`.
   - If adding an element exceeds `mid`, start a new subarray.
5. If the array can be split into `k` or fewer subarrays:
   - `mid` is a valid answer, so store it and search for a smaller value.
6. Otherwise, `mid` is too small, so search in the right half.

Key Binary Search Idea:
We are not searching for an element. We are searching for the minimum
possible value of the maximum subarray sum.

If a value `mid` is feasible, every value greater than `mid` is also
feasible. This monotonic property allows Binary Search on Answer.

Time Complexity: O(n log(sum(nums)))
Space Complexity: O(1)
*/

class Solution {
     private boolean check(int[] nums, int k, int mid) {
        int cntSubarrays = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                cntSubarrays++;
                sum = nums[i];
            }
        }
        return cntSubarrays <= k;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;

        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(nums, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
