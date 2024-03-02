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
    public boolean isPalindrome(ListNode head) {
        boolean ans=true;
        ListNode start=head;
        ListNode end=head ;
        ListNode slow=head;
        ListNode fast=head ;
        int st=0;
        int ed=0;

// FInding the Mid
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;

// Rversing the List from Mid
    ListNode prev=null,next=null,curr=mid;
     while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    curr=prev;
        System.out.println(curr.val+" "+start.val);

// Using 2 pointer from start and end matcing them 
    while(curr!=null){
        if(curr.val!=start.val)return false;
        System.out.println(curr.val+" "+start.val);
         curr=curr.next;
         start=start.next;
    }
 
    return ans;

        
    }
}