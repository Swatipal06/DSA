/*
Problem: Intersection of Two Linked Lists
Platform: LeetCode (160)

Approach:
1. Use two pointers, one for each linked list:
   - `a` starts at headA.
   - `b` starts at headB.
2. Move both pointers one node at a time.
3. When a pointer reaches the end of its list, redirect it to the
   head of the other list.
4. By switching lists, both pointers traverse the same total distance:
      Length(A) + Length(B)
5. If the lists intersect, both pointers will meet at the intersection
   node.
6. If they do not intersect, both pointers will eventually become null
   at the same time.

Why does this work?
- The different lengths of the two lists are automatically balanced
  when each pointer switches to the other list.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/ 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while( a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;    
        }
    
        return a;
    }
}
