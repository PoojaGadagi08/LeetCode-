Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.



  class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        
        char[] chArr = s.toCharArray();
        
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        
        Arrays.fill(firstOcc, -1);
        Arrays.fill(lastOcc, -1);
        
        for(int i = 0; i < n; i++){
            
            char ch = chArr[i];
            
            if(firstOcc[ch - 'a'] == -1){
                firstOcc[ch - 'a'] = i;
            }
            
            lastOcc[ch - 'a'] = i;
        }
        
        int ans = 0, count = 0;
        
        boolean[] visited;
        
		// check for each character ( start or end of palindrome )
        for(int i = 0; i < 26; i++){
            
            int si = firstOcc[i]; // si - starting index
            int ei = lastOcc[i]; // ei - ending index
            
            visited = new boolean[26];
            
            count = 0;
            
			// check for unique charcters ( middle of palindrome )
            for(int j = si + 1; j < ei; j++){
                
                if(!visited[chArr[j] - 'a']){
                    visited[chArr[j] - 'a'] = true;
                    count++;
                }
            }
            
            ans += count;
        }
        
        return ans;
    }
}
