/*
Problem: Combination Sum
Platform: LeetCode (39)

Approach:
1. Use Backtracking to generate all possible combinations.
2. Sort the array so that combinations are built in non-decreasing order.
3. At each step:
   - Choose the current number.
   - Reduce the remaining target.
   - Continue exploring from the same index because the same
     element can be used multiple times.
4. If the remaining target becomes:
   - 0  -> a valid combination is found.
   - <0 -> stop exploring that path.
5. After exploring a choice, remove the last element
   (backtrack) to try other possibilities.

Backtracking Steps:
- Choose
- Explore
- Undo

Time Complexity: Exponential in the worst case (number of valid combinations)
Space Complexity: O(target)   // Recursion depth excluding output space
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        }
        else { 
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);   //choose

                backtrack(list, temp, nums, remain - nums[i], i);   //explore
                temp.remove(temp.size() - 1);   //undo
            }
        }
        return;
    }
}
