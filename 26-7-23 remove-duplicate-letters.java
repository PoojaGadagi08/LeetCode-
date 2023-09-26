Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

  
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.










  class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] vis = new boolean[26];
        StringBuilder ans = new StringBuilder();
        
        int n = s.length();
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            if (vis[s.charAt(i) - 'a']) continue;
            
            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > s.charAt(i) && last[ans.charAt(ans.length() - 1) - 'a'] > i) {
                vis[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            
            ans.append(s.charAt(i));
            vis[s.charAt(i) - 'a'] = true;
        }
        
        return ans.toString();
    }
}
