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
    int getlen(ListNode h) {
        int l=0;
        while(h!=null) {
            l++;
            h=h.next;
        }
        return l;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode small, big;
        if(getlen(l1)<getlen(l2)) {
            small=l1;
            big=l2;
        } else {
            small=l2;
            big=l1;
        }
        int c=0;
        ListNode h = null,p=null;
        while(small!=null) {
            int d3 = small.val+big.val+c;
            if(d3>9) {
                c=1;
                d3-=10;
            } else {
                c=0;
            }
            ListNode n = new ListNode(d3);
            if(h==null) {
                h=n;
                p=n;
            } else {
                p.next=n;
                p=n;
            }
            small=small.next;
            big=big.next;
        }
        while(big!=null) {
            int d3 = big.val+c;
            if(d3>9) {
                c=1;
                d3-=10;
            } else {
                c=0;
            }
            ListNode n = new ListNode(d3);
            if(h==null) {
                h=n;
                p=n;
            } else {
                p.next=n;
                p=n;
            }
            big=big.next;
        }
        if(c==1) {
            ListNode n = new ListNode(1);
            p.next=n;
        }
        return h;
    }
}
