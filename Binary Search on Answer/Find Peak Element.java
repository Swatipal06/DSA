/*
Problem: Find Peak Element
Platform: LeetCode (162)

Approach:
1. Use Binary Search to find a peak element in O(log n).
2. Compare nums[mid] with nums[mid + 1]:
   - If nums[mid] < nums[mid + 1], we are on an increasing slope,
     so a peak must exist on the right side. Move l = mid + 1.
   - Otherwise, we are on a decreasing slope, so mid itself or
     a peak on the left side can be the answer. Move r = mid - 1.
3. When the search ends, l points to a peak element.
4. The problem guarantees that adjacent elements are different,
   and a peak may occur at either boundary.

Example:
nums = [1, 2, 3, 1]

mid = 1 -> nums[1] < nums[2]
Move right.

mid = 2 -> nums[2] > nums[3]
Move left boundary.

Result:
Index 2

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if(mid < n-1 && nums[mid] < nums[mid+1]) {
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
