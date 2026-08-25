/*
Problem: Trapping Rain Water
Platform: LeetCode (42)

Approach:
1. Use the Two Pointer approach with pointers `l` and `r`.
2. Maintain:
   - `lMax` = maximum height encountered from the left.
   - `rMax` = maximum height encountered from the right.
3. Compare `height[l]` and `height[r]`:
   - If `height[l] < height[r]`, process the left side:
     - Update `lMax`.
     - Water trapped at `l` is `lMax - height[l]`.
     - Move `l` forward.
   - Otherwise, process the right side:
     - Update `rMax`.
     - Water trapped at `r` is `rMax - height[r]`.
     - Move `r` backward.
4. Continue until the two pointers meet.
5. Return the total trapped water.

Key Two Pointer Idea:
The water trapped at a position depends on the smaller of the
maximum heights on its left and right.

By processing the side with the smaller current height, we know that
side's maximum is the limiting boundary, allowing us to calculate the
trapped water without storing separate prefix/suffix arrays.

Time Complexity: O(n)
Space Complexity: O(1)
*/ 

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int lMax=0, rMax=0;
        int water = 0;

        while(l<r) {
            if(height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }
}
