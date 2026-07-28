/*
Problem: Unique Paths
Platform: LeetCode (62)

Approach:
1. Use Dynamic Programming to store the number of unique paths
   to reach each cell.
2. Initialize:
   - First row = 1 because there is only one way to move right.
   - First column = 1 because there is only one way to move down.
3. For every remaining cell:
   - The current cell can be reached from:
       a) The cell above it.
       b) The cell on its left.
   - Therefore, the transition is:
       dp[i][j] = dp[i-1][j] + dp[i][j-1]
4. The value at the bottom-right cell represents the total number
   of unique paths from the top-left corner.

Time Complexity: O(m × n)
Space Complexity: O(m × n)

Optimization:
- This can be optimized to O(n) space by using a single 1D DP array.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
            }
        }
        return dp[m - 1][n - 1];
    }
}
