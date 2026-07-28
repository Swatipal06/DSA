/*
Problem: Sort Colors
Platform: LeetCode (75)

Approach:
1. Use the Dutch National Flag Algorithm to sort the array in one pass.
2. Maintain three pointers:
   - start: Boundary for placing 0s.
   - mid: Current element being processed.
   - end: Boundary for placing 2s.
3. Traverse the array using the mid pointer:
   - If nums[mid] == 0:
       Swap with start and move both start and mid forward.
   - If nums[mid] == 1:
       It is already in the correct section, so move mid forward.
   - If nums[mid] == 2:
       Swap with end and decrease end.
       Do not increase mid because the swapped element is not processed yet.
4. After the traversal:
   - Elements before start are 0s.
   - Elements between start and end are 1s.
   - Elements after end are 2s.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int mid = 0;
        int end = n-1;

        while(mid <= end){
            if(nums[mid] == 0){
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
