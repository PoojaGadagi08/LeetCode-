Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.





  // import java.util.List;
// import java.util.ArrayList;


// Brute Force Apporach

// class Solution {

//     public boolean isPalin(String s) {
//         int i = 0;
//         int j = s.length() - 1;

//         while (i <= j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }

//     public String longestPalindrome(String s) {
//         if (s.isEmpty()) {
//             return "";
//         }

//         int n = s.length();
//         List<String> allSubString = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j <= n; j++) {
//                 String substr = s.substring(i, j);
//                 allSubString.add(substr);
//             }
//         }

//         int lengthOfString = Integer.MIN_VALUE;
//         String longestPalindrome = "";

//         for (String str : allSubString) {
//             if (isPalin(str) && str.length() > lengthOfString) {
//                 longestPalindrome = str;
//                 lengthOfString = str.length();
//             }
//         }

//         return longestPalindrome;
//     }
// }



class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0; // Starting index of the longest palindrome substring
        int maxLength = 1; // Length of the longest palindrome substring

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length 3 and more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Check if the substring from index i to index j is a palindrome
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        // Extract the longest palindrome substring using start index and maxLength
        return s.substring(start, start + maxLength);
    }
}
