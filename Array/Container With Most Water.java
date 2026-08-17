/*
Problem: Container With Most Water
Platform: LeetCode (11)

Approach:
1. Use the Two Pointer technique with pointers at both ends of the array.
2. Calculate the area formed by the two pointers:
      Area = min(height[l], height[r]) × (r - l)
3. Update the maximum area found so far.
4. Move the pointer with the smaller height because the shorter
   line limits the container's height. Moving the taller pointer
   cannot increase the area.
5. Continue until the two pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while(l < r) {
            int area = Math.min(height[l], height[r]) * (r-l);
          
            max = Math.max(max, area);
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
