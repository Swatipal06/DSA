/*
Problem: Set Matrix Zeroes
Platform: LeetCode (73)

Approach:
1. Use two auxiliary arrays to track rows and columns that need
   to be converted to zero.
2. Traverse the matrix:
   - If an element is 0, mark its corresponding row and column.
3. Traverse the matrix again:
   - Set an element to 0 if its row or column is marked.
4. This ensures that all cells in the same row or column as an
   original zero become zero.

Time Complexity: O(m × n)
Space Complexity: O(m + n)

Optimization:
- The problem can also be solved with O(1) extra space by using
  the first row and first column of the matrix as markers.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
