You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.

 

Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 

Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] and s consists of only lowercase English letters
dictionary contains distinct words



  class Solution {
    public int minExtraChar(String s, String[] d) {
//         Stack <Character> ans=new Stack<>();
//        int c=0;
        
//         for(int i=0;i<s.length();i++){
//             for(int j=0;j<d.length;j++){
//                 if(s.charAt(i)!=(d[j].charAt(j))){
//                    ans.push(s.charAt(i));
//                 }
//             }
//         }
//          return ans.size()-21;
        
        
        int l=s.length();
        int l=le=d.length;
        
        int dp[]=new int[le+1];
        
        HashSet<String > h=new HashSet<>();
        for(int i=0;i<le;i++)
            j.add(d[i]);
        
        for(int i=l-1;i>=0;i--){
            String ste="";
            
            int m=dp[i+1];
            for(int j=1;j<l;j++){
                ste=ste+s.charAt(j)+"";
                
                if(h.contains(str)){
                    int e=astr.length();
                    e+=dp[j+1];
                    if(e>m)
                        m=e;
                }
            }
            dp[i]=m;
        }
        return l-dp[0];
    }
}
