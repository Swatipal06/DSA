/*
Problem: Find Minimum in Rotated Sorted Array
Platform: LeetCode (153)

Approach:
1. Use Binary Search to find the minimum element in the rotated array.
2. Compare nums[mid] with nums[r]:
   - If nums[mid] > nums[r], the minimum must be in the right half,
     so move l to mid + 1.
   - Otherwise, the minimum is at mid or in the left half,
     so move r to mid.
3. Continue until l == r.
4. The element at nums[l] is the minimum value.

Example:
nums = [4, 5, 6, 7, 0, 1, 2]

The binary search eliminates the sorted portion that cannot
contain the minimum and eventually reaches index 4.

Result:
0

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
      
        while(l < r) {
            int mid = l + (r-l) / 2;
          
            if(nums[mid] > nums[r]) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}
