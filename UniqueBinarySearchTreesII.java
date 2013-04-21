/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    ArrayList<TreeNode> foo(int s, int e) {
        ArrayList<TreeNode> r = new ArrayList<TreeNode>();
        if(s>e) {
            r.add(null);
            return r;
        }
        for(int i=s;i<=e;i++) {
            ArrayList<TreeNode> lt = foo(s,i-1);
            ArrayList<TreeNode> rt = foo(i+1,e);
            for(int j=0;j<lt.size();j++) {
                for(int k=0;k<rt.size();k++) {
                     TreeNode n = new TreeNode(i);
                     n.left=lt.get(j);
                     n.right=rt.get(k);
                     r.add(n);
                }
            }
        }
        return r;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> r = foo(1,n);
        return r;
    }
}
