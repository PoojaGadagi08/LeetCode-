Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.



  class Solution {
   public boolean wordBreak(String s, List<String> wordDict) {  
        Boolean [] dp = new Boolean[s.length()];
        return helper(0, s, wordDict, dp);
   }

   public boolean helper(int index, String s, List<String> wordDict, Boolean [] dp)
   {
       //step 3
       int n = s.length();
       if(index == n) return true;
       if(dp[index] != null) return dp[index];
       for(int k = index + 1; k <= n; k++)
       {
           //step 2
           if(wordDict.contains(s.substring(index, k)) && helper(k, s, wordDict, dp))
           return dp[index] = true;
       }
       return dp[index] = false;
   }
}
