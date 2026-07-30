/*
Problem: Linked List Cycle
Platform: LeetCode (141)

Approach:
1. Use Floyd’s Cycle Detection Algorithm (Tortoise and Hare).
2. Initialize two pointers:
   - slow: moves one step at a time.
   - fast: moves two steps at a time.
3. Traverse the linked list while fast and fast.next are not null.
4. If a cycle exists, the fast pointer will eventually meet
   the slow pointer inside the cycle.
5. If the fast pointer reaches the end of the list, there is no cycle.

Why does this work?
- In a cyclic list, the fast pointer gains one node on the slow
  pointer in every iteration, so they must eventually meet.
- In a non-cyclic list, fast reaches null first.

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
