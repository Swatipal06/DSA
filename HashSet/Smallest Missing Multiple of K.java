/*
Problem: Smallest Missing Multiple of K
Platform: LeetCode (2996)

Approach:
1. Store all elements of `nums` in a HashSet for O(1) average-time
   lookup.
2. Start with the first positive multiple of `k`, i.e. `mul = k`.
3. For every element in the array:
   - Add it to the set.
   - While the current multiple `mul` exists in the set, move to the
     next multiple by doing `mul += k`.
4. After processing the array, `mul` will be the smallest positive
   multiple of `k` that does not exist in `nums`.
5. Return `mul`.

Key Idea:
Only multiples of `k` matter. Instead of checking every possible
number, start from `k` and keep moving to the next multiple whenever
the current one is present in the array.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        int mul = k;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            set.add(nums[i]);

            while(set.contains(mul)) {
                mul += k;
            }

        }
        return mul;
    }
}
