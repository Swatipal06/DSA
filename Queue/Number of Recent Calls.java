/*
Problem: Number of Recent Calls
Platform: LeetCode (933)

Approach:
1. Use a Queue to store the timestamps of recent requests.
2. For each incoming request at time t:
   - Remove all timestamps that are older than (t - 3000),
     as they no longer belong to the required time window.
   - Add the current timestamp to the queue.
3. The remaining elements in the queue represent all requests
   made within the inclusive range [t - 3000, t].
4. Return the size of the queue.

Time Complexity: O(1) Amortized
Space Complexity: O(n)
*/

class RecentCounter {
    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        while(!q.isEmpty() && q.peek() < t-3000) {
            q.remove();
        }
        q.add(t);
        return q.size();
    } 
}
