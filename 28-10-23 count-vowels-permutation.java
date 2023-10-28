Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 

Constraints:

1 <= n <= 2 * 10^4




  class Solution {
    public int countVowelPermutation(int n) {
    int mod = 1000000007;
    long sum = 0;
    long[] v = new long[]{1, 1, 1, 1, 1}; // a-0, e-1, i-2, o-3, u-4
    for (int i = 1; i < n; i++) {
        long[] v1 = new long[5];
        v1[0] = (v[1] + v[2] + v[4]) % mod;
        v1[1] = (v[0] + v[2]) % mod;
        v1[2] = (v[1] + v[3]) % mod;
        v1[3] = v[2];
        v1[4] = (v[2] + v[3]) % mod;
        v = v1;
    }
    for (long i : v) 
        sum = (sum + i) % mod;
    return (int) sum;
}
}
