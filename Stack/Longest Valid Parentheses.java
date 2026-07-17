/*
Problem: Longest Valid Parentheses
Platform: LeetCode (32)

Approach:
1. Use a stack to store the indices of unmatched opening parentheses '('.
2. Traverse the string:
   - Push the index of every '(' onto the stack.
   - For every ')', if a matching '(' exists, mark both indices as valid.
3. After processing, the marked indices represent characters that belong
   to valid parentheses pairs.
4. Traverse the marked array to find the longest contiguous sequence
   of valid indices, which gives the length of the longest valid
   parentheses substring.

Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {
                if(st.isEmpty()) {
                    continue;
                }
                vis[i] = 1;
                vis[st.pop()] = 1;
            }
        }
        int cnt = 0;
        int ans = 0;

        for(int i=0; i<vis.length; i++) {
            if(vis[i] == 1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}
