Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.



  class Solution {
    // public boolean repeatedSubstringPattern(String s) {
    //     HashMap<Character,Integer> h=new HashMap<>();

    //     char arr[]=s.toCharArray();
    //     for(char a:arr){
    //         h.put(a,h.getOrDefault(a,0)+1);
    //     }

    //   if(s.length()==1)
    //       return false;
    // //   for(int i=0;i<s.length()-1;i++){
          
    // //       if(h.get(s.charAt(i))!=h.get(s.charAt(i+1))){
    // //           return false;
    // //       }
    // //   }

    //  Set<Integer> set = new HashSet<Integer>(h.values());
    //  if(set.size()==1)
    //  return true;

    //   return false;


    public boolean repeatedSubstringPattern(String str) {
	int l = str.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;
			String subS = str.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(str)) return true;
		}
	}
	return false;
}
    }
