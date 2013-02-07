import java.io.*;
import java.util.*;

public class BSTFindNextNode {
  TreeNode leftMostChild(TreeNode r) {
    TreeNode p = r.left;
    if(p==null) return r;
    while(p.left!=null)p=p.left;
    return p;
  }
  TreeNode rightMostChild(TreeNode r) {
    TreeNode p = r.right;
    if(p==null) return r;
    while(p.right!=null)p=p.right;
    return p;
  }

  /*
    if r has right: return leftmost of r.right
    get parent p of r. if p.left==r, return r;
    else: go up (r=p;p=p.parent) until p is null or p.left==r
   */
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

  /*
    if r has left: return rightmost of r.left
    get parent p of r. if p.right==r, return r;
    else: go up (r=p;p=p.parent) until p is null or p.right==r
    
  */
  TreeNode findPrevNode(TreeNode r) {
    if(r.left!=null) {
      return rightMostChild(r.left);
    } else {
      TreeNode p = r.parent;
      while(p!=null) {
        if(p.right==r) break; 
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
  void testFindPrevNode(TreeNode r) {
    if(r==null) return;
    testFindPrevNode(r.left);
    TreeNode nextNode = findPrevNode(r);
    System.out.println(r.val+" prev:" + (nextNode==null?"None":nextNode.val));
    testFindPrevNode(r.right);
  }

  void test() {
    BinaryTreeUtils btu = new BinaryTreeUtils();
    ArrayList<TreeNode> trees = btu.readTreesFromFile("bt1.txt"); 
    for(TreeNode tree:trees) {
      //testFindNextNode(tree);
      testFindPrevNode(tree);
      System.out.println("----------");
    }
  }

  public static void main(String[] argv) {
    new BSTFindNextNode().test();
  }
}
