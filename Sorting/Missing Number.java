/*
Problem: Missing Number
Platform: LeetCode (268)

Approach:
1. Sort the array in ascending order.
2. Use Binary Search to find the first index where:
       nums[mid] > mid
   This indicates that the expected number `mid` is missing.
3. Set the search range:
   - `l = 0`
   - `r = nums.length`
   The answer can also be `n`, so `r` is initialized to `n`.
4. If `nums[mid] > mid`:
   - The missing number is at `mid` or somewhere to its left.
   - Move `r` to `mid`.
5. Otherwise:
   - `nums[mid] == mid`, so all numbers up to `mid` are present.
   - Move `l` to `mid + 1`.
6. When `l == r`, `l` represents the first missing number.

Key Binary Search Idea:
After sorting, for every index before the missing number,
`nums[i] == i`. At the missing number, this relationship breaks:
`nums[i] > i`.

Binary Search finds the first position where this condition is true.

Time Complexity: O(n log n)
Space Complexity: O(log n) for sorting
*/

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int l = 0, r = nums.length;

        while(l < r) {
            int mid = (l + r)/2;

            if(nums[mid] > mid) {
                r = mid;
            }
            else l = mid+1;
        }
        return l;
    }
}
