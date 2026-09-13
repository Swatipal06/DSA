/*
Problem: Majority Element
Platform: LeetCode (169)

Approach:
1. Sort the array in ascending order.
2. Since the majority element appears more than `n / 2` times,
   it must occupy the middle position of the sorted array.
3. Return `nums[n / 2]` as the majority element.

Key Idea:
After sorting, the majority element will always cross the middle
index because it occurs more than half of the total number of elements.

Time Complexity: O(n log n)
Space Complexity: O(log n) for sorting
*/

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}
