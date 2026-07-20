/*
Problem: Sum of Subarray Minimums
Platform: LeetCode (907)

Approach:
1. Use Monotonic Stacks to determine the contribution of each element
   as the minimum in all subarrays.
2. Compute:
   - Previous Smaller Element (strictly smaller)
   - Next Smaller or Equal Element
3. For each element:
   - Left choices  = distance to the previous smaller element.
   - Right choices = distance to the next smaller or equal element.
4. The number of subarrays where arr[i] is the minimum is:
      leftChoices × rightChoices
5. Add each element's contribution:
      arr[i] × leftChoices × rightChoices
   while taking the result modulo 1e9 + 7.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    long MOD = 1000000007;  //or 1e9 + 7

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int n = arr.length;
        long ans = 0;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

         // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                rightMin[i] = n;
            } else {
                rightMin[i] = st.peek();
            }

            st.push(i);
        }
        
        for(int i=0; i<n; i++) {
            long left = i - leftMin[i];
            long right = rightMin[i] - i;

            ans = (ans + ((left * right)% MOD * arr[i])) % MOD;
        }
        return (int) ans;
    }
}
