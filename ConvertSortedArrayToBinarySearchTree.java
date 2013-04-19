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
    TreeNode foo(int[] num, int s, int e) {
        if(s>e) return null;
        int m = s+(e-s)/2;
        TreeNode n = new TreeNode(num[m]);
        n.left = foo(num,s,m-1);
        n.right = foo(num,m+1,e);
        return n;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return foo(num, 0,num.length-1);
    }
}
