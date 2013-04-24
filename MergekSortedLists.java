import java.io.*;
import java.util.*;
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
class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode x, ListNode y) {
        if (x.val<y.val)
            return -1;
        if (x.val > y.val)
            return 1;
        return 0;
    }
}
public class MergekSortedLists {
      public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNodeComparator lc = new ListNodeComparator();
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(10,lc);
        int k = 0;
        for(int i=0;i<lists.size();i++) {
            ListNode n = lists.get(i);
            if(n!=null) {
                q.add(n);
                k++;
            }
        }
        if(k==0) return null;
        ListNode h = null,p=null;
        while(k>0) {
            ListNode n = q.poll();
            if(h==null) {h = n;p=n;}
            else {
                p.next=n;
                p=p.next;
            }
            n=n.next;
            if(n==null) k--;
            else q.add(n);
        }
        return h;
        
    }
  public static void main(String[] args) {
    MergekSortedLists m = new MergekSortedLists();
    ArrayList<ListNode> lists = new ArrayList<ListNode>();
    ListNode n1 = new ListNode(1);
    n1.next = null;
    ListNode n2 = new ListNode(0);
    n2.next = null;
    lists.add(n1);
    lists.add(n2);
    ListNode h = m.mergeKLists(lists); 
  }
}
