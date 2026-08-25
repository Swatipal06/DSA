/*
Problem: Longest Common Prefix
Platform: LeetCode (14)

Approach:
1. Sort the array of strings lexicographically.
2. After sorting:
   - `strs[0]` will be the lexicographically smallest string.
   - `strs[n-1]` will be the lexicographically largest string.
3. The longest common prefix of all strings must also be the common
   prefix of these two extreme strings.
4. Compare characters of the first and last strings until they differ.
5. Return the substring containing the matching characters.

Key Idea:
After lexicographical sorting, the common prefix of the entire array
is determined by only the first and last strings.

Time Complexity: O(n log n * m)
Space Complexity: O(log n) for sorting
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        
        String s1 = strs[0];
        String s2 = strs[n-1];
        int idx = 0;
        
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
