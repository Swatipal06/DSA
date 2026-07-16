/*
Problem: Maximum Tastiness of Candy Basket
Platform: LeetCode (2517)

Approach:
1. Sort the candy prices to enable greedy selection.
2. Apply Binary Search on the minimum tastiness (minimum absolute
   difference between any two selected candies).
3. The search space is:
   - Low  = 0
   - High = Maximum price difference
4. For each candidate tastiness, greedily pick candies such that
   the difference between consecutive selected candies is at least
   the candidate value.
5. If at least k candies can be selected, try a larger tastiness.
   Otherwise, reduce the candidate tastiness.

Time Complexity: O(n log n + n log(maxPriceDifference))
Space Complexity: O(1)  // Ignoring the sorting algorithm's internal space
*/

class Solution {
    private boolean check(int[] price, int k, int mid) {
        int candies = 1;
        int lastPicked = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastPicked >= mid) {
                candies++;
                lastPicked = price[i];

                if (candies >= k) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);

        int l = 0;
        int r = price[n-1] - price[0];

        int ans = l;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(check(price, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
