/*
Problem: Rotate List
Platform: LeetCode (61)

Approach:
1. Handle edge cases:
   - Empty list
   - Single node
   - k = 0

2. Find:
   - Length of the linked list.
   - Tail node of the list.

3. Reduce unnecessary rotations:
      k = k % length
   If k becomes 0, return the original head.

4. Find the new tail:
   - It is the (length - k - 1)th node from the beginning.

5. The node after the new tail becomes the new head.

6. Break the list at the new tail and connect the old tail
   to the original head to complete the rotation.

Example:
1 -> 2 -> 3 -> 4 -> 5, k = 2

New tail = 3
New head = 4

Result:
4 -> 5 -> 1 -> 2 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode temp = head;
        int len = 1;

        while(temp.next != null) {
            len++;
            temp = temp.next;
        }
        ListNode tail = temp;
        k %= len;

        if(k == 0) {
            return head;
        }
        temp = head;

        for(int i=1; i<len-k; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;

        return newHead;
    }
}
