/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = 0;
        ListNode p = head;
        while(p!=null) {
            n++;
            p=p.next;
        }
        list=head;
        return sortedListToBST(0, n-1);
    } 
    
    TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        // same as (start+end)/2, avoids overflow
        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBST(start, mid-1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid+1, end);
        return parent;
    } 

    ListNode list; 

}
