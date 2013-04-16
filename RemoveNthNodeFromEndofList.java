/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = head, p2=head;
        int i=0;
        while(i<n&&p1.next!=null) {
            i++;
            p1=p1.next;
        }
        //n is too large
        if(p1.next==null&&i<n-1) {
            return head;
        }
        //n is first node
        if(p1.next==null&&i==n-1) {
            head=head.next;
            return head;
        }
        while(p1.next!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return head;
        
    }
}
