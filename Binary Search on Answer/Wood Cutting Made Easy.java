/*
Problem: WoodCutting Made Easy
Platform: InterviewBit

Approach:
1. Apply Binary Search on the cutting height.
2. The search space is:
   - Low  = 0
   - High = Maximum tree height
3. For each candidate cutting height, calculate the total wood
   obtained by cutting trees taller than that height.
4. If the collected wood is at least B, try a higher cutting height
   to maximize the saw height.
   Otherwise, decrease the cutting height.

Time Complexity: O(n * log(maxHeight))
Space Complexity: O(1)
*/

public class Solution {
    private boolean check(ArrayList<Integer> A, int B, int h) {
        long wood = 0;

        for (int height : A) {
            if (height > h) {
                wood += (height - h);
            }
        }

        return wood >= B;
    }

    public int solve(ArrayList<Integer> A, int B) {

        int low = 0;
        int high = 0;

        for (int height : A) {
            high = Math.max(high, height);
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(A, B, mid)) {
                ans = mid;        
                low = mid + 1;    
            } else {
                high = mid - 1;  
            }
        }

        return ans;
    }
}
