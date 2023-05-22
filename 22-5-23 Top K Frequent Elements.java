Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> m = new HashMap<>();

        for(int val: nums){
            m.put(val, m.getOrDefault(val,0)+1);
        }

        List<Map.Entry<Integer, Integer>> arr=new ArrayList<>(m.entrySet());

        arr.sort((a,b) -> b.getValue()-a.getValue());

        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr.get(i).getKey();
        }
        return res;
    }
}
