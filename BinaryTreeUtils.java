import java.io.*;
import java.util.*;

class IntRef {
  int val;
  public IntRef(int v) {
    val=v;
  }
}

public class BinaryTreeUtils {

  void pre_traverse(TreeNode h) {
    if(h!=null) {
      System.out.print("ROOT:"+h.val+" ");
      System.out.println();
      //System.out.print("L:");
      pre_traverse(h.left);
      //System.out.print("R:");
      pre_traverse(h.right);
    }
  }

  void mid_traverse(TreeNode h) {
    if(h!=null) {
      mid_traverse(h.left);
      System.out.println(h.val);
      mid_traverse(h.right);
    }
  }
  void post_traverse(TreeNode h) {
    if(h!=null) {
      post_traverse(h.left);
      post_traverse(h.right);
      System.out.println(h.val);
    }
  }

  /* print line by line with newline with one queue */
  void print_by_level_newline_oneq(TreeNode root) {
    Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
    if(root==null) return;
    curLevel.add(root);
    int curNum=1,nextNum=0;
    
    while(!curLevel.isEmpty()) {
      TreeNode n = curLevel.remove();
      if(n!=null) {
        curLevel.add(n.left);
        curLevel.add(n.right);
        nextNum+=2;
        System.out.print(n.val +" ");
        curNum--;
      }
      if(curNum==0) {
        curNum=nextNum;
        nextNum=0;
        System.out.println(); 
      }
    } 
  }

  /* print line by line with newline */
  void print_by_level_newline(TreeNode root) {
    Queue<TreeNode> curLevel = new LinkedList<TreeNode>(),  nextLevel = new LinkedList<TreeNode>();
    if(root==null) return;
    curLevel.add(root);
    
    while(!curLevel.isEmpty()) {
      TreeNode n = curLevel.remove();
      if(n!=null) {
        nextLevel.add(n.left);
        nextLevel.add(n.right);
        System.out.print(n.val +" ");
      }
      if(curLevel.isEmpty()) {
        System.out.println(); 
        Queue<TreeNode> t=curLevel;
        curLevel=nextLevel;
        nextLevel=t;
      }
    } 
    
  }
  void print_by_level(Queue<TreeNode> q) {
    while(!q.isEmpty()) {
      TreeNode n = q.remove();
      if(n!=null) {
        q.add(n.left);
        q.add(n.right);
        System.out.println(n.val);
      }
    } 
  }

  TreeNode buildTreeFromFile(StringReader br) {
    try {
      int i;
      while((i=br.read())!=-1) {
        char c = (char)i;
        //System.out.println(i+" "+c);
        if(c=='#') return null;
        else {
          TreeNode ltree = buildTreeFromFile(br);
          TreeNode rtree = buildTreeFromFile(br);
          TreeNode root = new TreeNode(c-48);
          root.left=ltree;
          root.right=rtree;
          return root;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return null;
  }

  boolean validBSTHelper(TreeNode r, IntRef prev) {
    if(r==null) return true;
    System.out.println("cur:"+r.val+" prev:"+prev.val);
    if(validBSTHelper(r.left,prev)) {
      if(prev.val<r.val) {
        prev.val=r.val;
        if(validBSTHelper(r.right, prev))
          return true;
      }
    }
    return false;
  }
  boolean isValidBST(TreeNode root) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    IntRef rInt = new IntRef(-100);
    return validBSTHelper(root, rInt);

  }

/*
  count nodes in a complete bt
*/
int countNodes(TreeNode root) {
    if ( root == null )
        return 0;
    if ( root.left == null )
        return 1;
    TreeNode ptr=root;
    int height=0;
    while ( ptr!=null ) {
        ++height;
        ptr = ptr.left;
    }
    ptr = root.left;
    int hTemp=0;
    while ( ptr!=null ) {
        ++hTemp;
        ptr = ptr.right;
    }
    if ( hTemp == height-1 )
        return ( 1 << hTemp ) + countNodes(root.right);
    else
        return ( 1 << hTemp ) + countNodes(root.left);    
}
  /*
     1
     2   3
     4   5

pre: 1 2 4 5 6
post: 4 5 2 3 1
in: 4 2 5 1 3
   */
  void test(String fn) { 
    try {
      FileReader fr = new FileReader(fn);
      BufferedReader br = new BufferedReader(fr);
      String s = null;
      while((s=br.readLine())!=null) {
        StringReader sr = new StringReader(s);
        System.out.println("input:"+s);
        TreeNode h = buildTreeFromFile(sr);
        /* print by level */
        System.out.println("by level");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(h);
        print_by_level_newline_oneq(h);
        System.out.println();

        /* print by pre */
        System.out.println("pre");
        pre_traverse(h);
        System.out.println();

        /* print by post */
        System.out.println("post");
        post_traverse(h);
        System.out.println();

        /* print by in */
        System.out.println("in");
        mid_traverse(h);
        System.out.println();

        boolean valid=isValidBST(h);
        System.out.println(valid);

        int cnt = countNodes(h); 
        System.out.println("#nodes:"+cnt);
      }
      br.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }

  public static void main(String[] argv) {
    BinaryTreeUtils btu = new BinaryTreeUtils();
    btu.test("bt1.txt"); 
  }
}
