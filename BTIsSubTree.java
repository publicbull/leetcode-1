import java.io.*;
import java.util.*;

public class BTIsSubTree {
  BinaryTreeUtils btu = new BinaryTreeUtils();
  Scanner scanner = null;
  void test() {
    scanner = new Scanner("1 2 4 # # 5 # # 3 6 # # 7 # #");
    TreeNode t1 = btu.buildTreeFromFile(scanner);
    scanner = new Scanner("2 4 # # 5 # #");
    TreeNode t2 = btu.buildTreeFromFile(scanner);
    btu.print_by_level_newline_oneq(t1);
    System.out.println();
    btu.print_by_level_newline_oneq(t2);
    System.out.println("----------");
    System.out.println(isSubTree(t1,t2));
  }

  boolean isSubTree(TreeNode t1, TreeNode t2) {
    if ( t2 == null ) return true;
    if ( t1 == null ) return false;
    if ( t1.val == t2.val) return isSubTree(t1.left,t2.left) && isSubTree(t1.right, t2.right);
    else return isSubTree(t1.left,t2) || isSubTree(t1.right, t2);
  }

  public static void main(String[] args) {
    new BTIsSubTree().test();
  }
}
