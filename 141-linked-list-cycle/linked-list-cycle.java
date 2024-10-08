 


// M1  Using Floyd 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode s=head;
        ListNode f=head.next;
        while(s!=f){
            if( f==null ||f.next==null)return false;

            s=s.next;
            f=f.next.next;

    }
    return true;
}
}


// M2  Using Hashset 

  class Solution2 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
} 

// M-3 
//since constraints for value are -10^5 <= Node.val <= 10^5
//then I use 1_000_000 as indicator that this node has been
//visited
  class Solution3 {
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 1_000_000) return true;
            head.val = 1_000_000;
            head = head.next;
        }
        return false;
    }
}