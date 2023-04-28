// Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. 
//   Also two strings X and Y are similar if they are equal.

// For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not 
// similar to "tars", "rats", or "arts".

// Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the 
// same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least
// one other word in the group.

// We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?



class Solution {
    public int numSimilarGroups(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        int res=0;
        
        for(int i=0; i<strs.length; i++){
            if(!visited[i]){
                res++; // as soon as we get inside, we see a new group
                dfs(strs, visited, i);
            }
        }
        return res;
    }
    
    private void dfs(String[] strs, boolean[] visited, int index){  
        visited[index] = true; // as soon as we get into recursion, the string is marked as visited (recursion satisfies 
      //the criteria of isSimilar so meaning same group)
        String curr = strs[index];
        
        for(int i=0; i<strs.length; i++){     
            if(!visited[i] && isSimilar(curr, strs[i])){
                dfs(strs, visited, i);
            }      
        }
    }
    
    
    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) // if at any 'i', chars mismatch, then add diff
                diff++;
        }
        
        return (diff == 2 || diff == 0); // similar only of they are identical (diff == 0) or 2 diff (so that we can do 1 swap)
    }
}
