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
  public ListNode swapPairs(ListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ListNode p = head;
    ListNode h = null;
    ListNode lastp=null;
    if(p==null||p.next==null) return head;
    while(p!=null&&p.next!=null) {
      ListNode q = p.next.next;
      p.next.next=p;
      if(h==null) h =p.next;
      if(lastp!=null)
        lastp.next=p.next;
      p.next=q;
      lastp=p;
      p = q;
    }
    return h; 
  }

  void swap(ListNode x, ListNode y) {
    int t = x.val;
    x.val=y.val;
    y.val=t;
  }
  public ListNode swapPairs(ListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ListNode p = head, np;
    while( p != null ) {
      np = p.next;
      if( np != null ) {
        swap( p, np );
        p = np.next;
      } else break;
    }
    return head;

  }
}
