/*
Problem: Sort List
Platform: LeetCode (148)

Approach:
1. Use Merge Sort to sort the linked list.
2. Find the middle node using the Fast and Slow Pointer technique.
3. Split the linked list into two halves by breaking the connection
   between the middle and the next node.
4. Recursively sort both halves.
5. Merge the two sorted halves using the `merge()` function.
6. Continue until each sublist contains only one node, which is
   already sorted.

Why Merge Sort?
- Linked lists do not support random access efficiently.
- Merge Sort works efficiently with linked lists because the list
  can be split and merged using only pointer manipulation.

Example:
4 -> 2 -> 1 -> 3

Split:
4 -> 2       1 -> 3

Sort:
2 -> 4       1 -> 3

Merge:
1 -> 2 -> 3 -> 4

Time Complexity: O(n log n)
Space Complexity: O(log n)   // Recursion stack
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = FindMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        
        return merge(left, right);
    }

    ListNode FindMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
