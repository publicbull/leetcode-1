
import java.io.*;
import java.util.*;

public class BSTSerialize {

  void serialize(TreeNode r, FileWriter fw) throws Exception {
    if(r==null) {fw.write("#");return;}
    fw.write(r.val+"");
    serialize(r.left, fw);
    serialize(r.right, fw); 
  }

  void test() {
    BinaryTreeUtils btu =new BinaryTreeUtils();
    ArrayList<TreeNode> trees = btu.readTreesFromFile("bt1.txt"); 
    try {
      FileWriter fw = new FileWriter("tmp.txt");
      serialize(trees.get(0),fw);
      fw.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public static void main(String[] argv) {
    new BSTSerialize().test();
  }
}
