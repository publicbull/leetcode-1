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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p = head,end=head;
        //null list
        //n>=length
        if(head==null) return null;
        int len=0;
        while(p!=null) {
            p=p.next;
            len++;
        }
        for(int i=0;i<len-1;i++) end=end.next;
        p=head;
        n=n%len;
        if(n==0) return head;
        for(int i=0;i<len-n-1;i++) {
            p=p.next;
        }
        ListNode h = p.next;
        end.next=head;
        p.next=null;
       
        return h;
    }
}
