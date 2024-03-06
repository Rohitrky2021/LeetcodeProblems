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
class Solution1 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) { // chotta waala add kro 
                p.next = p1;
                p1 = p1.next; // then us chotte  waale ka increase krdo pinter
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;  // main ans ke ontr ko increase kro
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return fakeHead.next;
    }
}


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}