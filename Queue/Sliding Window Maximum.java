/*
Problem: Sliding Window Maximum
Platform: LeetCode (239)

Approach:
1. Use a Monotonic Decreasing Deque to store the indices of
   elements in the current window.
2. For each element:
   - Remove indices from the back whose values are smaller than
     or equal to the current element, as they can never become
     the maximum.
   - Add the current index to the back of the deque.
3. Remove the front index if it falls outside the current window.
4. Once the first window is formed, the element at the front of
   the deque is the maximum for that window.
5. Repeat the process for all windows.

Time Complexity: O(n)
Space Complexity: O(k)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>(); 
        int idx = 0; 

        for(int i=0; i<n; i++) { 

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); 
            }
            dq.offerLast(nums[i]); 

            if(i >= k-1) { 
                ans.add(nums[dq.peekFirst()]);
            } 
            if(i-k+1 >= 0 && dq.peek() == nums[i-k+1]) {
                dq.peekFirst(); 
            } 
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
