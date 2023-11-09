Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
Example 2:

Input: s = "xy"
Output: 2
Explanation: The homogenous substrings are "x" and "y".
Example 3:

Input: s = "zzzzz"
Output: 15
 

Constraints:

1 <= s.length <= 105
s consists of lowercase letters.





  // class Solution {
//     public boolean isHomogenous(String str) {
//         // Compare each character in the substring with the first character
//         for (int i = 1; i < str.length(); i++) {
//             if (str.charAt(i) != str.charAt(0)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public int countHomogenous(String s) {
//         int mod = 1000000009;
//         int n = s.length();
//         int cnt = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j <= n; j++) {
//                 String subStr = s.substring(i, j);
//                 if (isHomogenous(subStr)) {
//                     cnt++;
//                     cnt %= mod; // Ensure that cnt does not exceed mod value
//                 }
//             }
//         }

//         return cnt;
//     }
// }




// class Solution {
//     public int countHomogenous(String s) {
//         int mod = 1000000009;
//         int n = s.length();
//         int cnt = 1; // Initialize count to 1 for the single characters in the string
//         int consecutiveCount = 1; // Initialize consecutive count to 1 for the first character

//         for (int i = 1; i < n; i++) {
//             if (s.charAt(i) == s.charAt(i - 1)) {
//                 consecutiveCount++;
//             } else {
//                 consecutiveCount = 1;
//             }
//             cnt = (cnt + consecutiveCount) % mod;
//         }

//         return cnt;

//     }
// }




class Solution {
    public int countHomogenous(String s) {
        long res  = 0;
        char[] c = s.toCharArray();
        int start =0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]!=c[start])
            {
                int appear = i-start;
                while(appear>0)
                {
                    res+=appear;
                    appear-=1;
                }
                start=i;
            }
        }

        int appear = c.length-start;
        while(appear>0)
        {
            res+=appear;
            appear-=1;
        }

        return (int)(res%(Math.pow(10,9)+7));
    }
}
