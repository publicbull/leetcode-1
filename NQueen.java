import java.io.*;
import java.util.*;

public class NQueen {
  boolean checkBoard(int[] sol,int k) {
    for(int i=0;i<k;i++) {
      if(sol[i]==sol[k]) return false;
      if(sol[i]-sol[k]==k-i) return false;
      if(sol[k]-sol[i]==k-i) return false;
    }
    return true;

  }
  void foo(int l, int n, ArrayList<String[]> result,int[] sol) {
    if(l==n) {
      String[] item = new String[n];
      for(int i=0;i<n;i++) {
        StringBuffer sb =new StringBuffer();
        for(int j=0;j<n;j++) sb.append(".");
        sb.setCharAt(sol[i],'Q');
        item[i]=sb.toString();
      }
      result.add(item);
      return;
    }
    for(int i=0;i<n;i++) {
      sol[l]=i;
      if(checkBoard(sol,l)) {
        foo(l+1,n,result,sol);
      }
    }
  }
  public ArrayList<String[]> solveNQueens(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String[]> result =new ArrayList<String[]>();
    int[] sol = new int[n];
    foo(0,n,result,sol);
    return result;

  }
  public static void main(String[] args) {
    NQueen nq = new NQueen();
    ArrayList<String[]> r =nq.solveNQueens(4);
    for(String[] s:r) {
      for(String ss:s)
        System.out.println(ss);
      System.out.println("---------------");
    }
  }
}


