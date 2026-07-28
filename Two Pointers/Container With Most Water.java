/*
Problem: Container With Most Water
Platform: LeetCode (11)

Approach:
1. Use the Two Pointer technique.
2. Initialize two pointers:
   - Left pointer at the beginning of the array.
   - Right pointer at the end of the array.
3. Calculate the area formed between the two pointers:
      Area = min(height[left], height[right]) × (right - left)
4. Update the maximum area found so far.
5. Move the pointer with the smaller height because increasing the
   width alone cannot improve the area if the smaller height remains
   the limiting factor.
6. Continue until both pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int l=0, r = height.length - 1;
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
