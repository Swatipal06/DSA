/*
Problem: Maximal Rectangle
Platform: LeetCode (85)

Approach:
1. Treat each row as the base of a histogram.
2. Maintain a height array where:
   - Increment the height if the current cell is '1'.
   - Reset the height to 0 if the current cell is '0'.
3. For every row, compute the Largest Rectangle in Histogram using
   Monotonic Increasing Stacks.
4. Keep track of the maximum rectangle area across all rows.

Largest Rectangle in Histogram:
- Find the Previous Smaller Element (PSE) and Next Smaller Element (NSE)
  for every bar using monotonic stacks.
- Width = NSE - PSE - 1
- Area = Height × Width
- The maximum area over all bars is the largest rectangle for that histogram.

Time Complexity: O(n × m)
Space Complexity: O(m)
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }

    public int largestRectangleArea(int[] h) {
        Stack<Integer> st = new Stack<>();
        int n = h.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }
            st.push(i);
        }

        int res = 0;
        
        for(int i=0; i<n; i++) {
            int currh = h[i];
            int currW = right[i] - left[i] - 1;

            res = Math.max(res, currh * currW);
        }
        return res;
    }
}
