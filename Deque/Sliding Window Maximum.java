/*
Problem: Sliding Window Maximum
Platform: LeetCode (239)

Approach:
1. Use a Monotonic Decreasing Deque to maintain the maximum element
   for the current sliding window.
2. Store indices of elements in the deque instead of values so that
   we can easily check whether an element has moved out of the window.
3. For every element:
   - Remove smaller or equal elements from the back because they
     cannot be the maximum for future windows.
   - Add the current index to the deque.
   - Remove the front index if it is outside the current window.
4. The front element of the deque always represents the maximum
   value of the current window.

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
