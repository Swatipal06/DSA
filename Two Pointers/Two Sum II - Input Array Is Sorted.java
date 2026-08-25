/*
Problem: Two Sum II - Input Array Is Sorted
Platform: LeetCode (167)

Approach:
1. Use the Two Pointer approach because the array is sorted.
2. Initialize:
   - `p1` at the beginning of the array.
   - `p2` at the end of the array.
3. Calculate the sum of `numbers[p1]` and `numbers[p2]`.
4. If the sum equals `target`, return their 1-based indices.
5. If the sum is less than `target`, move `p1` forward to increase
   the sum.
6. If the sum is greater than `target`, move `p2` backward to decrease
   the sum.
7. Continue until the two pointers meet.

Key Two Pointer Idea:
Since the array is sorted, moving the left pointer increases the sum
and moving the right pointer decreases the sum. This allows us to find
the required pair in a single traversal without using extra space.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int result[] = {-1, -1};
        
        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            
            if (sum == target) {
                result[0] = p1+1; result[1] = p2+1;
                return result;
            } else if (sum < target) {
                p1++; 
            } else {
                p2--; 
            }
        }

        return result;   
    }
}
