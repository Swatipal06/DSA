/*
Problem: Reverse Linked List
Platform: LeetCode (206)

Approach:
1. Use recursion to reverse the linked list.
2. Base case:
   - If the list is empty or has only one node, return that node.
3. Recursively reverse the remaining list starting from head.next.
4. After the recursive call:
   - head.next points to the last node of the reversed sublist.
   - Make that node point back to head:
         head.next.next = head
5. Set head.next = null to avoid creating a cycle.
6. Return the new head obtained from the recursive call.

Example:
1 -> 2 -> 3 -> null

Recursive calls:
reverse(1)
  reverse(2)
    reverse(3) returns 3

Rewiring:
3 -> 2
2 -> 1

Result:
3 -> 2 -> 1 -> null

Time Complexity: O(n)
Space Complexity: O(n)   // Recursion call stack
*/

class Solution {
    public ListNode reverseList(ListNode head) {  //recursive 
        if(head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }
}
