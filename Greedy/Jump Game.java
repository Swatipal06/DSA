/*
Problem: Jump Game
Platform: LeetCode (55)

Approach:
1. Use Dynamic Programming (Bottom-Up).
2. Create a boolean array `dp` where:
   - dp[i] = true means index i can reach the last index.
3. The last index is always reachable from itself:
      dp[n - 1] = true
4. Traverse the array from right to left.
5. For each index `i`:
   - `nums[i]` tells us the maximum distance we can jump.
   - Check all reachable positions from `i + 1` to
     `min(i + nums[i], n - 1)`.
6. If any of those positions can reach the last index
   (`dp[j] == true`), mark `dp[i] = true`.
7. Finally, return `dp[0]`.

Example:
nums = [2, 3, 1, 1, 4]

Starting from the end:
4 -> reachable
1 -> can reach 4
1 -> can reach 1
3 -> can reach 1/4
2 -> can reach 3

Therefore:
dp[0] = true

Time Complexity: O(n²)
Space Complexity: O(n)

Note:
- This is a DP solution.
- The problem can be optimized to O(n) time and O(1) space
  using the Greedy approach.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
      
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
      
        for(int i = n-2; i>=0; i--){
            int min = Math.min(i + nums[i], n - 1);
          
            for(int j = i + 1; j <=min; j++){
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
