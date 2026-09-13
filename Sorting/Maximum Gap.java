/*
Problem: Maximum Gap
Platform: LeetCode (164)

Approach:
1. Sort the array in ascending order.
2. Traverse the sorted array and calculate the difference between
   every pair of consecutive elements.
3. Keep track of the maximum difference using `diff`.
4. If the array contains fewer than 2 elements, return 0 because
   no gap can be formed.
5. Return the maximum gap found.

Key Idea:
After sorting, the maximum gap between any two consecutive elements
can be found by checking the difference between every adjacent pair.

Time Complexity: O(n log n)
Space Complexity: O(log n) for sorting
*/

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 2) {
            return 0;
        }
        int diff = 0;
        for(int i=1; i<n; i++) {
            diff = Math.max(diff, nums[i] - nums[i-1]);
        }
        return diff;
    }
}
