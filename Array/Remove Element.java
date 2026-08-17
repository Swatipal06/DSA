/*
Problem: Remove Element
Platform: LeetCode (27)

Approach:
1. Use the Two Pointer technique to remove all occurrences of `val`
   in-place.
2. Maintain `idx` as the position where the next valid element
   should be placed.
3. Traverse the array:
   - If nums[i] is not equal to `val`, copy it to nums[idx].
   - Increment idx.
4. After traversal, the first `idx` elements contain all elements
   that are different from `val`.
5. Return `idx` as the new length of the modified array.

Example:
nums = [3, 2, 2, 3], val = 3

After processing:
[2, 2, _, _]

Return:
2

Time Complexity: O(n)
Space Complexity: O(1)
*/ 

class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
