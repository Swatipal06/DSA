/*
Problem: Reverse Linked List II
Platform: LeetCode (92)

Approach:
1. Use a Dummy Node before the head to simplify cases where
   the reversal starts at the first node.
2. Move `prev` to the node just before the `left` position.
3. Set `cur` as the first node of the section that needs to be reversed.
4. Reverse the sublist using the head-insertion technique:
   - Remove the node after `cur`.
   - Insert it immediately after `prev`.
   - Repeat until the entire [left, right] section is reversed.
5. Return `dummy.next` as the new head.

Example:
1 -> 2 -> 3 -> 4 -> 5
left = 2, right = 4

Result:
1 -> 4 -> 3 -> 2 -> 5

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next; 
    }
}
