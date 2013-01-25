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
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>>  r = new ArrayList<ArrayList<Integer>>();

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int thislevel=1,nextlevel=0;
    ArrayList<Integer> item = new ArrayList<Integer>();
    if(root!=null) r.add(item);

    while(!q.isEmpty()) {
      TreeNode n = q.remove();

      if(n!=null) {
        --thislevel;
        item.add(n.val);
        if(n.left!=null) {
          q.add(n.left);++nextlevel;
        }
        if(n.right!=null) {
          q.add(n.right);++nextlevel;
        }
      }
      if(thislevel==0&&!q.isEmpty()) {
        thislevel=nextlevel;
        nextlevel=0;
        item = new ArrayList<Integer>();
        r.add(item);
      }

    }
    return r;
  }


}
