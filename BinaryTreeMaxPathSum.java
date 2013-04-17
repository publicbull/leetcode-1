/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//copied from http://www.mitbbs.com/mitbbs_article_t.php?board=JobHunting&gid=32254243
public class Solution {
    
     int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int l=dfs(root.left);
        int r=dfs(root.right);
        int m=root.val;
        if(l>0) m+=l;
        if(r>0) m+=r;
        
        max=Math.max(max,m);
        return Math.max(l,r)>0?Math.max(l,r)+root.val:root.val;
    }
    int max;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        max=-9999;
        dfs(root);
        return max;
        
    }
}
