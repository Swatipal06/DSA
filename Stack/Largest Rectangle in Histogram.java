/*
Problem: Largest Rectangle in Histogram
Platform: LeetCode (84)

Approach:
1. Use Monotonic Increasing Stacks to find the boundaries where each
   histogram bar can extend while remaining the minimum height.
2. Compute:
   - Previous Smaller Element (PSE)
   - Next Smaller Element (NSE)
3. For each bar:
   - Width = NSE - PSE - 1
   - Area  = Height × Width
4. The maximum area among all bars is the answer.

Note:
- Pop elements >= current height while finding both PSE and NSE.
  This correctly handles duplicate heights and prevents overcounting.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
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
