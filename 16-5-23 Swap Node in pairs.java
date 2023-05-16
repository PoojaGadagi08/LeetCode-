// TC=O(n)   SC=Constant

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        return head;

        ListNode temp=new ListNode();
        ListNode pre=temp;
        ListNode curr=head;

        while(curr!=null && curr.next!=null){
            pre.next=curr.next;
            curr.next=pre.next.next;
            pre.next.next=curr;
            pre=curr;
            curr=curr.next;
        }
        return temp.next;
        
    }
}
