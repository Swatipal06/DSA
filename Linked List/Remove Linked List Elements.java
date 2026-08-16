/*
Problem: Remove Linked List Elements
Platform: LeetCode (203)

Approach:
1. Remove all matching nodes from the beginning of the list.
2. Use a pointer `prev` to traverse the remaining list.
3. Check the next node's value:
   - If it equals `val`, skip that node using:
       prev.next = prev.next.next
   - Otherwise, move `prev` forward.
4. Continue until the end of the list.
5. Return the updated head.

Example:
1 -> 2 -> 6 -> 3 -> 6
val = 6

Result:
1 -> 2 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode prev = head;

        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
