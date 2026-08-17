/*
Problem: Search Insert Position
Platform: LeetCode (35)

Approach:
1. Use Binary Search on the sorted array.
2. If the target is found, return its index directly.
3. If nums[mid] < target, the target must be on the right,
   so move the left pointer to mid + 1.
4. Otherwise, move the right pointer to mid - 1.
5. When the loop ends, `l` represents the first position where
   the target can be inserted while keeping the array sorted.

Example:
nums = [1, 3, 5, 6], target = 2

Search ends with l = 1.

Result:
1

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
