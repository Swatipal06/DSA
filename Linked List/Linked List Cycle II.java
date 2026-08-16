/*
Problem: Linked List Cycle II
Platform: LeetCode (142)

Approach:
1. Use Floyd's Cycle Detection Algorithm (Fast and Slow Pointers).
2. Move:
   - slow by 1 step.
   - fast by 2 steps.
3. If slow and fast meet, a cycle exists.
4. To find the starting node of the cycle:
   - Reset slow to the head.
   - Keep fast at the meeting point.
   - Move both pointers one step at a time.
   - The node where they meet again is the cycle's starting node.
5. If fast reaches null, there is no cycle, so return null.

Why does resetting slow to head work?
- At the first meeting point, the distances traveled by the two
  pointers have a mathematical relationship with the cycle length.
- Moving one pointer from head and the other from the meeting point
  at the same speed makes them meet exactly at the cycle entry.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast =  head;

        while(fast != null) {
            fast = fast.next;

            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            if(slow == fast) {
                slow = head;
            
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
