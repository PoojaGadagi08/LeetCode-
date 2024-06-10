class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int expected[]= Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(heights[i]!=expected[i]) cnt++;
        }
        return cnt;
    }
}

