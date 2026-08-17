/*
Problem: Two Sum
Platform: LeetCode (1)

Approach:
1. Use a Brute Force approach with two nested loops.
2. For every element nums[i], check all elements after it
   to find a pair whose sum equals the target.
3. If nums[i] + nums[j] == target, return their indices.
4. If no valid pair is found, return an empty array.

Time Complexity: O(n²)
Space Complexity: O(1)

Note:
- A more optimized solution uses a HashMap and runs in O(n) time.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
