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
    int sum;
    int getIntValue(ArrayList<Integer> path) {
        int a=0;
        for(int i=0;i<path.size();i++) 
            a=a*10+path.get(i);
        return a;
    }
    void dfs(TreeNode n, ArrayList<Integer> path) {
        if(n==null) return;
        path.add(n.val);
        if(n.left==null&&n.right==null) {
            sum+=getIntValue(path);
        } else {
            dfs(n.left,path);
            dfs(n.right,path);
        }
        path.remove(path.size()-1);
    }
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        sum=0;
        ArrayList<Integer> path = new  ArrayList<Integer>();
        dfs(root,path);
        return sum;
    }
}
