class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int diff[]= new int[n];

       int right=0, left=0;
       int sum=0;
       int len=0;
       while(right<n){
        sum+=Math.abs(s.charAt(right)-t.charAt(right));
        
         if(sum>maxCost){
            sum-=Math.abs(s.charAt(left)-t.charAt(left));
            left++;
        }

        if(sum<=maxCost)
        len=Math.max(len, right-left+1);

        right++;
       }
        return len;
    }
}
