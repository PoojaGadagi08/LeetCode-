You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
  
  
  class Solution {
    public char nextGreatestLetter(char[] l, char t) {
        for(int i=0;i<l.length;i++){
            if(l[i]>t)
            return l[i];
        }
        return l[0];
    }
}
