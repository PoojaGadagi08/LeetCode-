class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;

        //  brute force O(n^2)
        // int cnt = 0;
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += nums[j];
        //         if (sum == goal) {
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

       int psum = 0, res = 0, count[] = new int[A.length + 1];
        count[0] = 1;
        for (int i : A) {
            psum += i;
            if (psum >= S)
                res += count[psum - S];
            count[psum]++;
        }
        return res;

    }
}
