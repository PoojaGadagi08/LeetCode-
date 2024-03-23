![image](https://assets.leetcode.com/users/images/1cef0f2a-8143-45ee-b2c3-58417fdb7aa3_1624714953.3397665.jpeg)
![image](https://assets.leetcode.com/users/images/d582cb78-f39e-4dae-9d52-94109194f378_1624714953.383273.jpeg)

class Solution 
{
    public void reorderList(ListNode head) 
    {
        int n=0;
        Stack<ListNode> track=new Stack<>();
        ListNode temp=head;
        
        while(temp != null)
        {
            track.push(temp);//pushing the node into the stack 
            temp=temp.next;
            n+=1;//counting the length 
        }
        
        temp=head;
        
        for (int i=0; i<n/2;i++)//traversing to only the half length 
        {
            ListNode str=temp.next;//storing the next node 
            
            temp.next=track.peek();//current node pointing to the next node 
            track.pop().next=str;//maintaining the link 
            
            temp=temp.next.next;//as the pair consist of 2, we are covering 2 node at a time 
        }
        
        temp.next = null;//to remove the cycle or the cyclic dependency of the elements
    }
}//Please do vote me, It helps a lot
