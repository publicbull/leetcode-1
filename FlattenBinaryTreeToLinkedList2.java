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
    TreeNode pre = null;
    public void _flatten(TreeNode root) {
        if (root != null) {
            _flatten(root.right);
            _flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
         }
    }
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre=null;
        _flatten(root);
    }
}
