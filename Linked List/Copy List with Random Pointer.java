/*
Problem: Copy List with Random Pointer
Platform: LeetCode (138)

Approach:
1. Use a HashMap to maintain a mapping between each original node
   and its corresponding copied node.
2. First traversal:
   - Create a new node for every original node.
   - Store the mapping:
       original node -> copied node
3. Second traversal:
   - Set the `next` pointer of each copied node using the map.
   - Set the `random` pointer using the map as well.
4. Return the copied node corresponding to the original head.

Why use a HashMap?
- The random pointer can point to any node in the list, so the map
  allows us to find the corresponding copied node in O(1) average time.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}
