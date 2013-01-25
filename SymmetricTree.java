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
  boolean foo(TreeNode l, TreeNode r) {
    if(l==null&&r==null) return true;
    if(l==null||r==null) return false;
    return (l.val==r.val)&&foo(l.left,r.right)&&foo(l.right,r.left);
  }
  public boolean isSymmetric(TreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(root==null)return true;
    return foo(root.left,root.right);
  }
}
