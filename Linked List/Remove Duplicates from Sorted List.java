/*
Problem: Remove Duplicates from Sorted List
Platform: LeetCode (83)

Approach:
1. Since the linked list is sorted, duplicate values will always
   appear next to each other.
2. Use a pointer `current` to traverse the linked list.
3. If the current node and the next node have the same value:
   - Skip the duplicate node by updating:
       current.next = current.next.next
4. Otherwise, move `current` to the next node.
5. Continue until the end of the list is reached.

Example:
1 -> 1 -> 2 -> 3 -> 3

After removing duplicates:
1 -> 2 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
