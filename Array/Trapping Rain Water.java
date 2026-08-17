/*
Problem: Trapping Rain Water
Platform: LeetCode (42)

Approach:
1. For every index, the amount of water trapped depends on the
   maximum height to its left and right.

2. Create `leftMax[]`:
   - leftMax[i] stores the maximum height from index 0 to i.

3. Create `rightMax[]`:
   - rightMax[i] stores the maximum height from index i to n - 1.

4. For every position:
      waterLevel = min(leftMax[i], rightMax[i])

   Water trapped at index i:
      waterLevel - height[i]

5. Add the trapped water from every position to get the final answer.

Example:
height = [0,1,0,2,1,0,1,3,2,1,2,1]

The water trapped at each position is determined by the smaller
of the maximum barriers on its left and right.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
- This is the Prefix/Suffix Maximum approach.
- It can be optimized to O(1) space using the Two Pointer technique.
*/

class solution {
  public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
    
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        int rightMax[] = new int [n];
        rightMax[n-1] = height[n-1];
    
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
    
        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
     }
}
