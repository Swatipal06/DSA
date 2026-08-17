/*
Problem: Search in Rotated Sorted Array
Platform: LeetCode (33)

Approach:
1. Use Modified Binary Search because the array is sorted but rotated.
2. At every iteration, find the middle element.
3. One of the two halves is always sorted:
   - If nums[l] <= nums[mid], the left half is sorted.
   - Otherwise, the right half is sorted.
4. Check whether the target lies within the sorted half:
   - If yes, search in that half.
   - Otherwise, search in the other half.
5. Continue until the target is found or the search space becomes empty.

Example:
[4, 5, 6, 7, 0, 1, 2], target = 0

At each step, identify the sorted half and eliminate the
half where the target cannot exist.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0, r = n-1;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(nums[mid] ==  target) {
                return mid;
            }
            
            else if (nums[l] <= nums[mid]) {
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
