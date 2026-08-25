/*
Problem: Isomorphic Strings
Platform: LeetCode (205)

Approach:
1. Use two arrays to store the last seen position of each character:
   - `indexS` for string `s`.
   - `indexT` for string `t`.
2. Traverse both strings simultaneously.
3. For every pair of characters:
   - Compare their previously stored positions.
   - If the positions are different, the character mappings are
     inconsistent, so return false.
4. Store `i + 1` as the latest position of both characters.
   Using `i + 1` allows `0` to represent a character that has not
   appeared before.
5. If the complete strings are processed without any mismatch,
   return true.

Key Idea:
Two strings are isomorphic when characters at the same positions
have the same previous occurrence pattern.

The two arrays ensure a one-to-one mapping between characters of
`s` and `t`.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[200]; 
        int[] indexT = new int[200]; 
        
        int len = s.length();
        
        if(len != t.length()) {
            return false;
        }
        
        for(int i = 0; i < len; i++) {

            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false;
            }
            indexS[s.charAt(i)] = i + 1;
            indexT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
