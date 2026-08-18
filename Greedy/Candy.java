/*
Problem: Candy
Platform: LeetCode (135)

Approach:
1. Create a `candies` array and initially give every child 1 candy.
2. Traverse from left to right:
   - If the current child's rating is greater than the previous child's,
     give the current child one more candy than the previous child.
3. Traverse from right to left:
   - If the previous child's rating is greater than the current child's,
     update the previous child's candies using:
       max(candies[i] + 1, candies[i-1])
   - `Math.max()` ensures that the left-to-right condition is not violated.
4. Add all the candies and return the total.

Key Greedy Idea:
Process the ratings from both directions:
- Left to right handles increasing sequences.
- Right to left handles decreasing sequences.
Using `Math.max()` ensures both conditions are satisfied simultaneously.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int count = 0;
        int[] candies = new int[n];

        for(int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = n-1; i > 0; i--) {
            if(ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            }
            count += candies[i-1];
        }

        return count + candies[n-1];
    }
}
