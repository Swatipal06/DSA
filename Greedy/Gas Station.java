/*
Problem: Gas Station
Platform: LeetCode (134)

Approach:
1. First calculate the total gas and total cost.
2. If total gas is less than total cost, completing the circuit
   is impossible, so return -1.
3. Use a Greedy approach to find the starting station:
   - Maintain `currGas` as the current surplus of gas.
   - Start with `st = 0`.
4. For each station:
   - Add the net gas:
       gas[i] - cost[i]
   - If `currGas` becomes negative, the current starting point
     cannot reach station `i + 1`.
   - Therefore, reset `currGas = 0` and choose `i + 1` as the
     new starting point.
5. Since the total gas is guaranteed to be enough, the final
   `st` is the valid starting station.

Key Greedy Idea:
If you cannot reach the next station starting from `st`, then
none of the stations between `st` and `i` can be a valid starting
point either.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totGas = 0, totCost = 0;

        for (int i=0; i<n; i++) {
            totGas += gas[i];
            totCost += cost[i];
        }

        if (totGas < totCost) {
            return -1;
        }

        int currGas = 0;
        int st = 0;

        for (int i=0; i<n; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                st = i + 1;
            }
        }
        return st;
    }
}
