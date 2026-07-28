/*
Problem: Middle of the Linked List
Platform: LeetCode (876)

Approach:
1. Use the Fast and Slow Pointer technique.
2. Move:
   - Slow pointer by 1 step.
   - Fast pointer by 2 steps.
3. When the fast pointer reaches the end of the list,
   the slow pointer will be at the middle node.
4. If the list has two middle nodes, return the second middle node
   as required by the problem.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode i = head, j = head;

        while(j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }
        return i;
    }
}
