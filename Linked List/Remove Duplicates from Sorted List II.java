/*
Problem: Remove Duplicates from Sorted List II
Platform: LeetCode (82)

Approach:
1. Use a Dummy Node to handle duplicate values at the beginning
   of the linked list.
2. Maintain two pointers:
   - prev: Points to the last node confirmed to contain a unique value.
   - cur: Traverses the linked list.
3. If cur.val == cur.next.val:
   - Move cur forward until all nodes with the same value are skipped.
   - Connect prev.next to cur.next, removing all duplicates.
4. If the current value is unique:
   - Move prev forward.
5. Continue until the list is completely traversed.
6. Return dummy.next as the new head.

Example:
1 -> 2 -> 2 -> 3 -> 3 -> 4

After removing all duplicate values:
1 -> 4

Time Complexity: O(n)
Space Complexity: O(1)
*/ 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {

                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
