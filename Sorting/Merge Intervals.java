/*
Problem: Merge Intervals
Platform: LeetCode (56)

Approach:
1. Sort the intervals based on their starting points.
2. Add the first interval to an `ArrayList`.
3. Traverse the remaining intervals one by one.
4. For each interval, compare its starting point with the ending point
   of the last merged interval.
5. If the current interval overlaps with the last interval:
   - Merge them by updating the ending point to the maximum of both
     ending points.
6. If there is no overlap, add the current interval as a new interval.
7. Convert the `ArrayList` into a 2D array and return the result.

Key Greedy Idea:
After sorting by starting time, we only need to compare the current
interval with the last merged interval.

If the current start is less than or equal to the previous end, the
intervals overlap and can be merged. Otherwise, they remain separate.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {
    public int[][] merge(int[][] intervals) {
             
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int n = intervals.length;

        list.add(intervals[0]);

        for(int i=1; i<n; i++) {
            int i1 = list.get(list.size() - 1)[0];
            int e1 = list.get(list.size() - 1)[1];

            int i2 = intervals[i][0];
            int e2 = intervals[i][1];

            if(i2 <= e1) {
                list.get(list.size() - 1)[i] = Math.max(e1, e2);
            } else {
                list.add(intervals[i]);
            }
        }
        int ans[][] = new int[list.size()][2];
        return ans;
    }
}
