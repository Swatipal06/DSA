/*
Problem: Design Linked List
Platform: LeetCode (707)

Approach:
1. Implement a Singly Linked List with:
   - head: Points to the first node.
   - tail: Points to the last node for O(1) insertion at the end.
   - currSize: Stores the current number of nodes.

2. Operations:
   - get(index):
       Traverse to the given index and return its value.
       Return -1 for an invalid index.

   - addAtHead(val):
       Create a new node and make it the new head.
       If the list was empty, update tail as well.

   - addAtTail(val):
       Append a new node after tail.
       If the list is empty, reuse addAtHead.

   - addAtIndex(index, val):
       Insert a node before the given index.
       Handle insertion at head, tail, and middle separately.

   - deleteAtIndex(index):
       Remove the node at the given index.
       Handle deletion of head, tail, single-node list,
       and middle nodes separately.

3. A helper method getNodeAtIndex(index) is used to avoid
   repeated traversal logic.

Time Complexity:
- get: O(n)
- addAtHead: O(1)
- addAtTail: O(1)
- addAtIndex: O(n)
- deleteAtIndex: O(n)

Space Complexity: O(1) auxiliary space
*/


class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head = null;
    Node tail = null;
    int currSize = 0;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index < 0 || index >= currSize) {
            return -1;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if(currSize == 0) {
            tail = head;
        }
        currSize++;
    }
    
    public void addAtTail(int val) {
        if(currSize == 0) {
            addAtHead(val);
        } else {
            tail.next = new Node(val);
            tail = tail.next;
            
            currSize++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > currSize) {
            return;
        } else if(index == 0) {
            addAtHead(val);
        } else if(index == currSize) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node prevNode = getNodeAtIndex(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            currSize++;
        }
    }
    
    private Node getNodeAtIndex(int index) {
        if(index < 0 || index >= currSize) {
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= currSize) {
            return;
        } else if(currSize == 1) {
            head = null;
            tail = null;
        } else if(index == 0) {
            head = head.next;
        } else if(index == currSize-1) {
            Node prevNode = getNodeAtIndex(index - 1);
            prevNode.next = null;
            tail = prevNode;
        } else {
            Node prevNode = getNodeAtIndex(index - 1);
            prevNode.next = prevNode.next.next;
        }
        currSize--;
    }
}
