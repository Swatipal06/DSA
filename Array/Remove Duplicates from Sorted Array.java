/*
Problem: Remove Duplicates from Sorted Array
Platform: LeetCode (26)

Approach:
1. Use the Two Pointer technique to remove duplicates in-place.
2. Since the array is sorted, duplicate elements will be adjacent.
3. Maintain `k` as the position where the next unique element
   should be placed.
4. Traverse the array from index 1:
   - If nums[i] is different from the previous element, it is unique.
   - Place it at nums[k] and increment k.
5. The first `k` elements of the array will contain all unique values.

Example:
nums = [1, 1, 2, 2, 3]

After processing:
[1, 2, 3, 2, 3]

Return:
3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int k = 1;
      
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
