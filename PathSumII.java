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
    void foo(TreeNode root, int sum, ArrayList<ArrayList<Integer>>  r, ArrayList<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        if(root.val==sum&&root.left==null&&root.right==null) {
            r.add((ArrayList<Integer>)path.clone());
            //2 lines below can be removed if yuo want to be short
            //path.remove(path.size()-1);
            //return;
        }
        foo(root.left,sum-root.val,r,path);
        foo(root.right,sum-root.val,r,path);
        path.remove(path.size()-1);
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>>  r = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> path = new ArrayList<Integer>();
        foo(root,sum,r,path);
        return r;
    }
    
}
