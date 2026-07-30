/*
Problem: Palindrome Linked List
Platform: LeetCode (234)

Approach:
1. Find the middle of the linked list using the Fast and Slow Pointer technique.
   - slow moves 1 step.
   - fast moves 2 steps.
   - For even-length lists, slow stops at the first middle node.

2. Reverse the second half of the linked list starting from slow.next.

3. Compare the first half and the reversed second half node by node.
   - If any pair of values differs, the list is not a palindrome.

4. If all corresponding nodes match, the linked list is a palindrome.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { 
            return true; 
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null) {
            fast = fast.next;
        
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        ListNode sec = reverse(slow.next);
        ListNode first = head;

        while(sec != null) {
            if(first.val != sec.val) {
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        return true;
    }
    public ListNode reverse(ListNode slow) {
        ListNode prev = null;
        
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        return prev;
    }
}
