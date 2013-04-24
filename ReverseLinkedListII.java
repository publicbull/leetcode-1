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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre = head,p,p1=null,q,qn;
        int l = n-m;
        while(pre!=null&&m>2) {
            pre = pre.next;
            m--;
        }
        if(m==1) {
            p=head;
            if(p==null) return head;
            q=p.next;
        }  else {
            if(pre==null) return head;
            p1=pre.next;p=pre.next;
            if(p==null) return head;
            q=p.next;qn=null;
        }
        while(l>0&&p!=null&&q!=null) {
            qn=q.next;
            q.next=p;
            p=q;
            q=qn;
            --l;
        }
        
        if(m==1) {
            head.next=q;
            head=p;
        } else {
            pre.next=p;
            p1.next=q;
        }
        return head;
        
    }
}
