/*
Problem: Find First and Last Position of Element in Sorted Array
Platform: LeetCode (34)

Approach:
1. Use Binary Search twice to find the boundaries of the target.
2. `first()` finds the first occurrence:
   - When target is found, store the index.
   - Continue searching in the left half for an earlier occurrence.
3. `last()` finds the last occurrence:
   - When target is found, store the index.
   - Continue searching in the right half for a later occurrence.
4. If the target does not exist, both methods return -1.

Example:
nums = [5, 7, 7, 8, 8, 10], target = 8

First occurrence = 3
Last occurrence  = 4

Result = [3, 4]

Time Complexity: O(log n)
Space Complexity: O(1)
*/ 

class Solution {
    private int first(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        int ans = -1;

        while(l <= r) {
            int mid = l + (r-l) / 2;

            if(arr[mid] == target) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private int last(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        int ans = -1;

        while(l <= r) {
            int mid = l + (r-l) / 2;

            if(arr[mid] == target) {
                ans = mid;
                l = mid+1;
            } else if(arr[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] {first(nums, target), last(nums, target)};
    }
}
