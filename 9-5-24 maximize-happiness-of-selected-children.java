class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        int arr[]=h;
        int l=arr.length;
        Arrays.sort(arr);
        
        int d=1;
        int last=l-1;
        
        long a=arr[last];
        k--;
        last--;
        
        while(k>0){
            int v =arr[last];
            int r=v-d;
            if(r>0)
                a+=r;
            
            d++;
            last--;
                k--;
        }
        return a;
    }
}
