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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode p = dummy;
        boolean skip=false;
        int skipval=-1;

        while(p.next.next!=null) {
            if(p.next.val==p.next.next.val) {
                skip=true;
                skipval=p.next.val;
            } else {
                if(skip&&p.next.val==skipval) {
                    p.next=p.next.next;
                }
                else {p = p.next;}
                skip=false;
            }

            if(skip&&p.next.val==skipval) {
                p.next=p.next.next;
            }
        }
        //delete the last node
        if(skip&&p.next.val==skipval) p.next=p.next.next;
        
        return dummy.next;
        
    }
}
