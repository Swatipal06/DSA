/*
Problem: Next Permutation
Platform: LeetCode (31)

Approach:
1. Find the first index `idx1` from the right such that:
      nums[idx1] < nums[idx1 + 1]
   This is the first position that can be increased.

2. If no such index exists, the array is in descending order.
   Therefore, it is the last permutation, so reverse the entire
   array to obtain the smallest permutation.

3. Otherwise, find the first index `idx2` from the right such that:
      nums[idx2] > nums[idx1]
   This is the smallest element greater than nums[idx1].

4. Swap nums[idx1] and nums[idx2].

5. Reverse the subarray from idx1 + 1 to the end.
   Since this portion was in descending order, reversing it gives
   the smallest possible suffix.

Example:
[1, 2, 3]

Find idx1 = 1 (2 < 3)
Find idx2 = 2 (3 > 2)

Swap:
[1, 3, 2]

Reverse suffix:
[1, 3, 2]

Result:
[1, 3, 2]

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx1 = -1;
        int idx2 = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;
            }
        }

        if(idx1 == -1) {
            reverse(nums, 0);
        } else {
            for(int i=n-1; i>=0; i--){
                if(nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
            swap(nums, idx1, idx2);

            reverse(nums, idx1+1);
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
      
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
