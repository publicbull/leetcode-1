import java.io.*;
import java.util.*;

public class SumRoottoLeafNumbers {
  BinaryTreeUtils btu = new BinaryTreeUtils();
  Scanner scanner = null;
  int sum=0;

  void test() {
    scanner = new Scanner("1 2 4 # # 5 # # 3 6 # # 7 # #");
    TreeNode t1 = btu.buildTreeFromFile(scanner);
    ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
    foo(t1,ls);
  } 

  void addToSum(ArrayList<TreeNode> ls) {
    int rc=0;
    for(TreeNode tn : ls) {
      rc=rc*10+tn.val;
    }    
    sum+=rc;
  }

  void foo(TreeNode t, ArrayList<TreeNode> ls) {
    if(t==null) return;
    if(t.left==null && t.right==null) {
      ls.add(t);
      addToSum(ls);
      ls.remove(ls.size()-1);
      return;
    }
    else {
      ls.add(t);
      foo(t.left,ls);
      foo(t.right,ls);
      ls.remove(ls.size()-1);
    }   
  }

  public int sumNumbers(TreeNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
    sum=0;
    foo(root,ls);
    return sum;
  }

  public static void main(String[] args) {
    new SumRoottoLeafNumbers().test();
  }
}
