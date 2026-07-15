/*
Problem: Painter's Partition Problem
Platform: GeeksforGeeks (GFG)

Approach:
1. Apply Binary Search on the answer (minimum possible maximum time).
2. The search space is:
   - Low  = Maximum board length (at least one painter must paint the largest board).
   - High = Sum of all board lengths (one painter paints everything).
3. For each candidate time, greedily assign consecutive boards to painters
   without exceeding the allowed time.
4. If the required painters are <= k, try a smaller maximum time.
   Otherwise, increase the allowed time.

Time Complexity: O(n * log(sum(arr)))
Space Complexity: O(1)
*/

class Solution {
     private int check(int[] arr, long time) {
        int painters = 1;
        long currTime = 0;

        for (int board : arr) {
            if (currTime + board <= time) {
                currTime += board;
            } else {
                painters++;
                currTime = board;
            }
        }

        return painters;
    }

    public long minTime(int[] arr, int k) {
        long l = 0, r = 0;

        for (int board : arr) {
            l = Math.max(l, board);
            r += board;
        }

        long ans = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (check(arr, mid) <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
