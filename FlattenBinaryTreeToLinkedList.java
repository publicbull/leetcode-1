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
    TreeNode findEnd(TreeNode n) {
        while(n.right!=null) {
            n=n.right;
        }
        return n;
    }
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null||root.left==null&&root.right==null) return ;
        else if(root.left!=null&&root.right==null) {
            flatten(root.left);
            root.right=root.left;
            root.left=null;
        }
        else if(root.left==null&&root.right!=null) {
            flatten(root.right);
        } else {
            flatten(root.left);
            flatten(root.right);
            TreeNode t = root.right;
            root.right=root.left;
            root.left=null;
            findEnd(root.right).right=t;
        }
        
    }
}
