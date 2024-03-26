class Solution {
    public int firstMissingPositive(int[] A) {
        int n=A.length;
        //  boolean vis[]=new boolean[n+1];
        // for(int i=0;i<n;i++){
        
        //     if(arr[i]>0 && arr[i]<=n)
        //     vis[arr[i]]=true;
        // }
        
        // for(int i=1;i<=n;i++){
        //     if(!vis[i])
        //     return i;
        // }
        // return n+1;
          for(int i = 0; i < n; ++ i) {
            while(A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1])
                // swap(A[i], A[A[i] - 1]);
                {
                    int t = A[A[i] - 1]; A[A[i] - 1] = A[i];  A[i]=t;
                }
        }
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
      
    }
}
