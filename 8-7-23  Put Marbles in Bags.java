You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.

Divide the marbles into the k bags according to the following rules:

No bag is empty.
If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
The score after distributing the marbles is the sum of the costs of all the k bags.

Return the difference between the maximum and minimum scores among marble distributions.

 

Example 1:

Input: weights = [1,3,5,1], k = 2
Output: 4
Explanation: 
The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6. 
The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10. 
Thus, we return their difference 10 - 6 = 4.
Example 2:

Input: weights = [1, 3], k = 2
Output: 0
Explanation: The only distribution possible is [1],[3]. 
Since both the maximal and minimal score are the same, we return 0.




  class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairs = new int[n - 1];
        for (int i = 1; i < n; i++) {
            pairs[i - 1] = weights[i] + weights[i - 1];
        }
        Arrays.sort(pairs);
        long minScore = 0;
        long maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += pairs[i];
            maxScore += pairs[n - i - 2];
        }
        return maxScore - minScore;
    }
}













// class Solution
// {
//     // arr[]: input array
//     // n: size of the array
//     //Function to find triplets with zero sum.
// 	public boolean findTriplets(int arr[] , int n)
//     {
//         //add code here.
//         int c=0;
//         for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 for(int k=j+1;k<arr.length;k++){
//                 if(arr[i]+arr[j]+arr[k]==0)
//                 c++;
//             }
//         }
//         }
//         if(c>1) return true;
//         return false;
//     }
// }
