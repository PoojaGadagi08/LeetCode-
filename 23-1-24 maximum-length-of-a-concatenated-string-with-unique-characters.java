You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.



  class Solution {
    int max =0;
    public int maxLength(List<String> arr) {
        backTrack(arr,"",0);
        return max;
    }
    
    private void backTrack(List<String> arr, String current, int start){
        if(max<current.length())
            max =current.length();
        for(int i=start; i<arr.size();i++){
            if(!isValid(current,arr.get(i))) continue;
            backTrack(arr,current+arr.get(i),i+1);
        }
    }
    
    private boolean isValid(String currentString, String newString){
        int[] array = new int[26];
        for(int i=0;i<newString.length();i++){
            if(++array[newString.charAt(i)-'a'] == 2) return false;  //to handle if the newString has duplicates then it's not valid
            if(currentString.contains(newString.charAt(i)+"")) // check if the currentString contains each char from newString
                return false;
        }
        return true;
    }
}
