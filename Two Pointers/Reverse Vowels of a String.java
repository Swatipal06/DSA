/*
Problem: Reverse Vowels of a String
Platform: LeetCode (345)

Approach:
1. Convert the string into a character array so that characters can
   be modified in-place.
2. Use the Two Pointer approach:
   - `l` starts from the beginning.
   - `r` starts from the end.
3. Move `l` forward until a vowel is found.
4. Move `r` backward until a vowel is found.
5. Swap the vowels at `l` and `r`.
6. Move both pointers inward and repeat until they meet.
7. Convert the character array back into a string and return it.

Key Two Pointer Idea:
Only vowels need to be swapped. The left pointer finds the next vowel
from the left, while the right pointer finds the next vowel from the
right. Swapping these vowels reverses their order while leaving all
consonants unchanged.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();

        int l = 0;
        int r = s.length()-1;

        String vow = "aeiouAEIOU";
        
        while (l < r) {
            while (l < r && vow.indexOf(ch[l]) == -1) {
                l++;
            }

            while (l < r && vow.indexOf(ch[r]) == -1) {
                r--;
            }

            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;

            l++;
            r--;
        }
        String answer = new String(ch);
        return answer;
    }
}
