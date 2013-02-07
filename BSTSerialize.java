
import java.io.*;
import java.util.*;

public class BSTSerialize {

  TreeNode deserialize(FileReader fr) throws Exception {
    int i=0;
    if((i=fr.read())!=-1) {
      char c= (char)i;
      if(c=='#') return null;
      TreeNode n = new TreeNode(i-48);
      TreeNode left = deserialize(fr);
      TreeNode right = deserialize(fr);
      n.left=left;
      n.right=right; 
      return n;
    } 
    return null;
  }

  void serialize(TreeNode r, FileWriter fw) throws Exception {
    if(r==null) {fw.write("#");return;}
    fw.write(r.val+"");
    serialize(r.left, fw);
    serialize(r.right, fw); 
  }

  void testDeserialize(String fn) {
    BinaryTreeUtils btu =new BinaryTreeUtils();
    try {
      FileReader fr = new FileReader(fn);
      TreeNode root = deserialize(fr);
      btu.print_by_level_newline_oneq(root);
      fr.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  void testSerialize() {
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
    new BSTSerialize().testDeserialize("tmp.txt");
  }
}
