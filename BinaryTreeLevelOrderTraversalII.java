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
    
    void dfs(TreeNode n,int level, ArrayList<ArrayList<Integer>>  r) {
        if(n==null) return;
        if(r.size()<=level) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            r.add(item);
        }
        r.get(level).add(n.val);
        dfs(n.left,level+1,r);
        dfs(n.right,level+1,r);
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>>  r = new ArrayList<ArrayList<Integer>>();
        dfs(root,0,r);
        Collections.reverse(r);
        return r;
    }
}
