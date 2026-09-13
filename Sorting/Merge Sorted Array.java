/*
Problem: Merge Sorted Array
Platform: LeetCode (88)

Approach:
1. Copy all elements of `nums2` into the empty positions at the end
   of `nums1`, starting from index `m`.
2. After both arrays are combined into `nums1`, sort the entire array.
3. Since `nums1` has enough space to store all elements, the final
   sorted array is the merged result.

Key Idea:
Use the extra space already provided at the end of `nums1` to first
store all elements of `nums2`, then sort the combined array.

Time Complexity: O((m + n) log(m + n))
Space Complexity: O(log(m + n)) for sorting
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        return;
    }
}
