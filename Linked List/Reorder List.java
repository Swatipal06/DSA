/*
Problem: Reorder List
Platform: LeetCode (143)

Approach:
1. Find the middle of the linked list using the Fast and Slow Pointer
   technique.
2. Split the list into two halves:
   - First half starts from head.
   - Second half starts from slow.next.
3. Reverse the second half of the linked list.
4. Merge the two halves alternately:
   - First node from the first half.
   - First node from the reversed second half.
   - Second node from the first half.
   - Second node from the reversed second half.
5. Continue until all nodes from the second half are merged.

Example:
1 -> 2 -> 3 -> 4 -> 5

Split:
1 -> 2 -> 3
4 -> 5

Reverse second half:
5 -> 4

Merge:
1 -> 5 -> 2 -> 4 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head.next;    //I middle

        while (fast != null) {
            fast = fast.next;

            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }   

        ListNode second = slow.next;   //reverse second half
        slow.next = null;
        ListNode node = null;

        while(second != null) {
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }

        ListNode first = head;  //Merge the two halves
        second = node;

        while(second != null) {
            ListNode temp1 = first.next, temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
