You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.



  class Solution {
    public boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;

        int first=0;
        int second=0;

        while(first<s1.length()){
            if(second < s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else 
            first++;
        }

        return first==s1.length() && second==s2.length();
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        int max=1;

        for(int i=0;i<n;i++){
            for(int preind=0;preind<i;preind++){
                if(compare(words[i], words[preind]) && 1+dp[preind]>dp[i]){
                    dp[i]=1+dp[preind];
                }
            }

            if(dp[i]>max)
            max=dp[i];
        }

        return max;
    }
}
