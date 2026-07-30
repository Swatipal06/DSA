/*
Problem: Add Two Numbers
Platform: LeetCode (2)

Approach:
1. Use a dummy node to simplify the construction of the result linked list.
2. Traverse both linked lists simultaneously while at least one list
   still has nodes.
3. For each position:
   - Add the current digits from both lists.
   - Add the carry from the previous step.
4. Create a new node with:
      sum % 10
5. Update the carry:
      sum / 10
6. Move to the next nodes of both lists.
7. After the traversal, if a carry remains, append it as a new node.
8. Return the node next to the dummy node, which is the head of the result list.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))   // Space used by the output list
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int c = 0;

        while(l1 != null || l2 != null) {
            int currSum = c;

            if(l1 != null) {
                currSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                currSum += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(currSum % 10);
            dummy.next = newNode;

            c = currSum / 10;
            dummy = dummy.next;
        }
        if(c > 0) {
            dummy.next = new ListNode(c); 
        }

        return temp.next;
    }
}
