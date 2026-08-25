/*
Problem: Find K-th Smallest Pair Distance
Platform: LeetCode (719)

Approach:
1. Sort the array so that pair distances can be counted efficiently.
2. Use Binary Search on Answer:
   - `l = 0` because the minimum possible distance is 0.
   - `h = max(nums) - min(nums)` because this is the maximum
     possible pair distance.
3. For each `mid`, use `countPairs()` to count how many pairs have
   a distance less than or equal to `mid`.
4. In `countPairs()`:
   - Use a sliding window with two pointers `left` and `right`.
   - Move `left` forward while the current pair distance is greater
     than `mid`.
   - For every `right`, there are `right - left` valid pairs ending
     at `right`.
5. If the number of pairs with distance <= `mid` is at least `k`,
   `mid` can be the answer, so search the left half.
6. Otherwise, search the right half.
7. The smallest valid distance is the k-th smallest pair distance.

Key Binary Search Idea:
Binary search the distance rather than the pair itself.

For a given distance `mid`, if there are at least `k` pairs with
distance <= `mid`, then the answer is `mid` or smaller.

Time Complexity: O(n log n + n log D)
where `D = max(nums) - min(nums)`

Space Complexity: O(log n) for sorting
*/


class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1] - nums[0];
        while(l < h) {
            int mid = l + (h-l)/2;
            if(countPairs(nums, mid) >= k) {
                h = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++) {
            while(nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
