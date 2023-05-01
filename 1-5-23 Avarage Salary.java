// You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

// Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.

class Solution {
    public double average(int[] salary) {
        double ans=0;
        Arrays.sort(salary);
        for(int i=1;i<salary.length-1;i++){
            ans+=salary[i];
        }
        return ans/(salary.length-2);
    }
}
