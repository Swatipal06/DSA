`/* Problem: Count the Number of Fair Pairs
Platform: LeetCode (2563) 
Approach: 
1. Sort the array to enable binary search on pair sums. 
2. Count the number of pairs with sum <= upper. 
3. Count the number of pairs with sum <= lower - 1. 
4. The required number of fair pairs is: count(<= upper) - count(<= lower - 1) 
5. For each index i: - 
  Compute the maximum allowed partner value: rem = target - nums[i] - Use upperBound to find how many elements are <= rem. 
- Only count indices strictly less than i to avoid duplicate and self pairs. 
Time Complexity: O(n log n) 
Space Complexity: O(1) // Ignoring sorting algorithm space 
*/`

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return cntPairs(nums, upper) - cntPairs(nums, (long) lower - 1);
    }

    private long cntPairs(int[] nums, long target) {
        long cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            long rem = target - nums[i];
            int idx = upperBound(nums, rem);
            cnt += Math.min(i, idx);
        }
        return cnt;
    }

    private int upperBound(int[] nums, long target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
