/*
Problem: Max Chunks To Make Sorted
Platform: LeetCode (769)

Approach:
1. Traverse the array while maintaining:
   - currSum: Sum of elements seen so far.
   - expSum: Sum of indices from 0 to i.
2. For a valid chunk in a permutation of [0, n-1]:
   - The set of elements in the current prefix must match the set
     of expected elements {0, 1, ..., i}.
   - If both sums are equal, the current prefix can form an
     independent chunk.
3. Increment the chunk count whenever:
      currSum == expSum
4. Return the total number of chunks.

Time Complexity: O(n)
Space Complexity: O(1)

Note:
- This sum-based approach works because the array is a permutation
  of numbers from 0 to n-1.
- A more commonly used approach is to track the maximum value seen
  so far and form a chunk whenever maxSoFar == i.
*/


class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int currSum = 0, expSum = 0;
        int chunks = 0;

        for(int i=0; i<n; i++) {
            currSum += arr[i];
            expSum += i;

            if(currSum == expSum) {
                chunks++;
            }
        }
        return chunks;
    }
}
