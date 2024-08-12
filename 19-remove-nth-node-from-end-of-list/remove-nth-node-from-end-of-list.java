 

//         Using Two Pointer Approach:
//         Take a pointer second and put it at (n+1)th position from the beginning
//         Take pointer first and move it forward till second reaches Last Node and second.next points to null
//         At that point we would have reached the (n-1)th node from the end using the pointer first
//         Unlink or Skip that node

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp, second = temp;

        while (n > 0) {
            second = second.next;
            n--;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        return temp.next;
    }
}
 
class Solution2 {
  
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) return null;

        int len = 0; // Variable to store the length of the list
        ListNode check = head; // Pointer to traverse the list for length calculation
        ListNode st = head; // Pointer to find the node before the one to be removed

        // Calculate the length of the list
        while (check != null) {
            check = check.next;
            len++;
        }

        // If the node to remove is the first node
        if (n - len + 1 == 1) return head.next;

        // Move to the node before the one to be removed
        int i = 1;
        while (i != len - n + 1 - 1 && st.next != null) {
            st = st.next;
            i++;
        }

        // Remove the nth node from the end
        if (st.next != null)
            st.next = st.next.next;
        else
            st.next = null;

        return head;
    }
}

class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int len=0,i=1;
        ListNode  check=head,st=head;

        while(check!=null){
            check=check.next;
            len++;
        }
        if(n-len+1==1)return head.next;

        // From start it will be ( N- k+1){}

        while(i!=len-n+1-1 && st.next!=null ){
            st=st.next;
            i++;
        }

        if(st.next!=null)
                st.next=st.next.next;
        else st.next=null;        
        // while(i!=len-k+1-1){
        //     st=st.next;
        // }


        return head;
    }
}
