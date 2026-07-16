/*
Problem: Final Prices With a Special Discount in a Shop
Platform: LeetCode (1475)

Approach:
1. Traverse the prices array from right to left.
2. Use a Monotonic Non-Decreasing Stack to maintain possible discounts.
3. Remove all prices greater than the current price, as they cannot
   serve as the first valid discount.
4. If the stack is not empty, the top element is the first price
   less than or equal to the current price, so subtract it.
   Otherwise, no discount is available.
5. Push the current price onto the stack for future elements.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for(int i=n-1; i>=0; i--) {
            int curr = prices[i];

            while(!st.isEmpty() && st.peek() > curr) {
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = curr;
            } else {
                res[i] = curr - st.peek();
            }
            st.push(curr);
        }

        return res;
    }
}
