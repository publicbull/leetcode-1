import java.io.*;
import java.util.*;

public class SubSetII {
  void sub(int[] num,int s, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    result.add((ArrayList<Integer>)path.clone());
    for(int i=s;i<num.length;i++) {
      if(i!=s&&num[i]==num[i-1]) continue;
      path.add(num[i]);
      sub(num,i+1,path,result);
      path.remove(path.size()-1);
    }
  }

  ArrayList<ArrayList<Integer>>  subsetsWithDup(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    sub(num,0,path,result);
    return result;
  }

  public static void main(String[] args) {
    int[] num = new int[]{1,1,2};
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> rc = new SubSetII().foo(num);
    for(ArrayList<Integer> ar: rc) {
      for(Integer i: ar) {
        System.out.print(i+" ");
      }
      System.out.println();
    }
  }
}
