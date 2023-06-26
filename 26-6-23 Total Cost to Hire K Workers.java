You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.

 

Example 1:

Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
Output: 11
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
The total hiring cost is 11.
Example 2:

Input: costs = [1,2,4,1], k = 3, candidates = 3
Output: 4
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
- In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
- In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
The total hiring cost is 4.











  class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        if(costs.length==1){
            return costs[0];
        }
        System.out.println(costs.length);
        int min1=0;
        int min2=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<costs.length;i++){
            list.add(costs[i]);
        }
        long cost=0;
        int win1=0;
        int win2=0;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();      
        if(candidates*2<=costs.length){  //if candidates are less than half of array then we are including elements of candiates size in both priority queue
            for(int i=0,j=costs.length-1;i<candidates;i++){
                pq1.add(costs[i]);
                pq2.add(costs[j]);
                win2=j;             //store idx where window2 ends
                j--;
                win1=i;              //stores idx where window1 ends
            }
        }
        else{
            for(int i=0,j=costs.length-1;i<costs.length/2;i++){   // if candidates are more than half of arraysize then we are including half half elements of array in both priority queue
                pq1.add(costs[i]);
                pq2.add(costs[j]);
                win2=j;
                j--;
                win1=i;
            }
        }
        
        for(int i=0;i<k;i++){  // now for k workers
         if(!pq1.isEmpty() && !pq2.isEmpty()){   
            min1=pq1.peek();
            min2=pq2.peek();
           
             if(min2<min1){  //if pq1 has min cost
                cost+=min2;
                pq2.remove();
                if(win1!=win2-1){ //window 1 needs to be updated since one candidate is included and remove next candidate will be added if condition is met
                    win2=win2-1;
                    pq2.add(costs[win2]);
                    
                }
                 
            }
            else{
                cost+=min1;
                pq1.remove();
                if(win1+1!=win2){ //window 2 needs to be updated since one candidate is included and remove next candidate will be added if condition is met
                    win1=win1+1;
                    pq1.add(costs[win1]);
                    
                }
            }
          
          }
          else if(!pq1.isEmpty()){ 
                cost+=pq1.remove();

          }
          else if(!pq2.isEmpty()){
                cost+=pq2.remove();
                
          }
          else{
                break;
          }
        }
        return cost;
    }
}
