/*
Problem: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Platform: LeetCode (1438)

Approach:
1. Use the Sliding Window technique with two Monotonic Deques.
2. Maintain:
   - Maximum deque: Stores indices in decreasing order of values.
     The front always contains the maximum element in the window.
   - Minimum deque: Stores indices in increasing order of values.
     The front always contains the minimum element in the window.
3. Expand the right pointer and add elements to both deques while
   maintaining their monotonic properties.
4. If the difference between the maximum and minimum element in the
   current window exceeds the limit:
   - Remove the leftmost index if it is the maximum/minimum element.
   - Shrink the window by moving the left pointer.
5. The maximum valid window size is the required answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        Deque<Integer> dqMax = new ArrayDeque<> ();
        Deque<Integer> dqMin = new ArrayDeque<> ();

        int i, j = 0;

        for(i=0; i<n; i++) {
            while(!dqMax.isEmpty() && nums[dqMax.peekLast()] <= nums[i]) {
                dqMax.pollLast();
            }
            dqMax.offerLast(i);

            while(!dqMin.isEmpty() && nums[dqMin.peekLast()] >= nums[i]) {
                dqMin.pollLast();
            }
            dqMin.offerLast(i);

            if((nums[dqMax.peek()] - nums[dqMin.peek()]) > limit) {
                if(dqMax.peek() == j) {
                    dqMax.poll();
                }
                if(dqMin.peek() == j) {
                    dqMin.poll();
                }
                j++;
            }
        }
        return i-j;
    }
}
