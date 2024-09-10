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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;

        while(temp.next!=null){

            ListNode node=new ListNode(0);

            node.val=gcd(temp.val,temp.next.val);

            node.next=temp.next;

            temp.next=node;
            temp=temp.next.next;

        }

        return head;
    }

    public int gcd(int a,int b){

        if(b==0)return a;

        return gcd(b,a%b);
    }
}