import java.io.*;
import java.util.*;

public class BSTFindNextNode {
  /*
     count nodes in a complete bt
http://www.mitbbs.com/article_t1/JobHunting/32303343_0_2.html
   */
  TreeNode leftMostChild(TreeNode r) {
    TreeNode p = r.left;
    if(p==null) return r;
    while(p.left!=null)p=p.left;
    return p;
  }

  TreeNode findNextNode(TreeNode r) {
    if(r.right!=null) {
      return leftMostChild(r.right);
    } else {
      TreeNode p = r.parent;
      //if(p==null) return r; 
      while(p!=null) {
        if(p.left==r) break; 
        r=p;p=p.parent;
      }
      return p;
    }
  }

  void testFindNextNode(TreeNode r) {
    if(r==null) return;
    testFindNextNode(r.left);
    TreeNode nextNode = findNextNode(r);
    System.out.println(r.val+" next:" + (nextNode==null?"None":nextNode.val));
    testFindNextNode(r.right);
  }

  void test() {
    BinaryTreeUtils btu = new BinaryTreeUtils();
    ArrayList<TreeNode> trees = btu.readTreesFromFile("bt1.txt"); 
    for(TreeNode tree:trees) {
      testFindNextNode(tree);
      System.out.println("----------");
    }
  }

  public static void main(String[] argv) {
    new BSTFindNextNode().test();
  }
}
