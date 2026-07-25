/*
Problem: Time Needed to Buy Tickets
Platform: LeetCode (2073)

Approach:
1. Use a Queue to simulate the ticket-buying process.
2. Initially, enqueue the indices of all people.
3. In each iteration:
   - Dequeue the person at the front.
   - Decrease their remaining ticket count by one.
   - Increment the elapsed time.
4. If the person still needs more tickets, enqueue them again.
5. If they have finished buying tickets and their index is k,
   return the total elapsed time.

Time Complexity: O(totalTickets)
Space Complexity: O(n)
*/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();

        int time = 0;
        int n= tickets.length;

        for (int i=0; i<n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            time++; 

            int front = q.remove();
            tickets[front]--; 

            if (tickets[front] != 0) {
                q.add(front);
            } else {
                if (front == k) {
                    return time;
                }
            }
        }
        return time;
    }
}
