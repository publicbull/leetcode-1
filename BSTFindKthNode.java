import java.io.*;
import java.util.*;

public class BSTFindKthNode {

  /*
   */
  void findKthNode(TreeNode r, int[] k) {
    if(r==null) return;
    findKthNode(r.left,k);
    if(k[0]==0)
      System.out.println(r.val);
    --k[0];
    findKthNode(r.right,k);
  }


  void test() {
    BinaryTreeUtils btu = new BinaryTreeUtils();
    ArrayList<TreeNode> trees = btu.readTreesFromFile("bt1.txt"); 
    for(TreeNode tree:trees) {
      int[] k=new int[1];
      k[0]=1;
      findKthNode(tree,k);
      System.out.println("----------");
    }
  }

  public static void main(String[] argv) {
    new BSTFindKthNode().test();
  }
}
