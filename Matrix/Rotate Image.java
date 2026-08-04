/*
Problem: Rotate Image
Platform: LeetCode (48)

Approach:
1. Rotate the matrix by 90 degrees clockwise in-place.
2. Step 1: Transpose the matrix
   - Swap matrix[i][j] with matrix[j][i] for all j > i.
   - This converts rows into columns.
3. Step 2: Reverse each row
   - Swap the first and last elements of every row,
     then move inward.
4. After transposition and row reversal, the matrix becomes
   rotated by 90° clockwise.

Example:
1 2 3
4 5 6
7 8 9

After transpose:
1 4 7
2 5 8
3 6 9

After reversing each row:
7 4 1
8 5 2
9 6 3

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){

              int temp=matrix[i][j];
              matrix[i][j]=matrix[j][i];
              matrix[j][i]=temp;
            }
        }
      for(int i=0;i<matrix.length;i++){
        int c=0;
        int d=matrix.length-1;
        
        while(c<d){
            int m=matrix[i][c];
            matrix[i][c]=matrix[i][d];
            matrix[i][d]=m;
            c++;
            d--;
        }
      }
    }
}
