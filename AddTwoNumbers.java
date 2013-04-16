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
    int getLen(ListNode n) {
        int len=0;
        while(n!=null) {
            n=n.next;
            len++;
        }
        return len;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode big=l1,small=l2;
        int lbig=getLen(l1);
        int lsmall=getLen(l2);
        if(lbig<lsmall) {
            big=l2;
            small=l1;
            int t = lbig;
            lbig=lsmall;
            lsmall=t;
        }
        int carry=0;
        ListNode pb=big,ps=small;
        ListNode h = null,p = null;
        while(ps!=null) {
            int s = ps.val+pb.val+carry;
            if(s>9) {s-=10;carry=1;}
            else carry=0;
            pb.val=s;
            if(h==null) h=pb;
            if(p==null) p=pb;
            else {p.next=pb;p=pb;}
            pb=pb.next;
            ps=ps.next;
        }
        while(pb!=null) {
            pb.val+=carry;
            if(pb.val>9) {
                carry=1;
                pb.val-=10;
            }else carry=0;
            p.next=pb;
            p=pb;
            pb=pb.next;
        }
        if(carry>0) {
            ListNode n = new ListNode(carry);
            p.next=n;
        }
        return h;
        
    }
}
