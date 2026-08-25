/*
Problem: Move Zeroes
Platform: LeetCode (283)

Approach:
1. Use the Two Pointer approach.
2. Maintain `l` as the position where the next non-zero element
   should be placed.
3. Traverse the array using `r`.
4. Whenever `nums[r]` is non-zero:
   - Swap `nums[r]` with `nums[l]`.
   - Increment `l`.
5. This moves all non-zero elements to the front while keeping all
   zeroes towards the end.
6. The relative order of the non-zero elements is preserved.

Key Two Pointer Idea:
`r` scans the entire array, while `l` keeps track of the next
available position for a non-zero element.

Swapping only when a non-zero element is found moves zeroes to the
right without requiring an extra array.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;

        for (int r=0; r<nums.length; r++) {
            if (nums[r] != 0) {

                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }  
    }
}
