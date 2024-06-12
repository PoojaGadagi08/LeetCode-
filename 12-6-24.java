class Solution {
    public void sortColors(int[] n) {
        int c0=0;
        int c1=0;
        int c2=0;

        for(int i=0;i<n.length;i++){
            if(n[i]==0)
            c0++;
            else if(n[i]==1)
            c1++;
            else
            c2++;
        }
        for(int i=0;i<n.length;i++){
            if(c0>0){
                n[i]=0;
                c0--;
            }
            else if(c1>0){
                n[i]=1;
                c1--;
            }
            else{
                n[i]=2;
                c2--;
            }
        }
    }
}
