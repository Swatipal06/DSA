/*
Problem: Remove K Digits
Platform: LeetCode (402)

Approach:
1. Use a monotonic increasing stack to build the smallest possible number.
2. Traverse each digit of `num`:
   - While `k > 0`, the stack is not empty, and the top digit is
     greater than the current digit, remove the top digit.
   - This makes the resulting number smaller and uses one removal.
3. Push the current digit into the stack.
4. If `k` is still greater than 0 after processing all digits,
   remove digits from the end of the stack.
5. Build the result while removing leading zeros.
6. If the resulting string is empty, return `"0"`.

Key Greedy Idea:
Remove a larger digit before a smaller digit whenever possible.
This makes the number smaller from the most significant position.

The stack maintains digits in increasing order, ensuring that every
removal contributes to obtaining the smallest possible number.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for(char ch: num.toCharArray()) {
            while (k>0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k > 0) {
            st.pop();
            k--;
        }
        for(char c : st) {
            if(ans.length() == 0 && c == '0') {
                continue;
            }
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
