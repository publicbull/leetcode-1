import java.io.*;
import java.util.*;

public class NQueenII {
  int num=0;
  boolean checkBoard(int[] sol,int k) {
    for(int i=0;i<k;i++) {
      if(sol[i]==sol[k]) return false;
      if(sol[i]-sol[k]==k-i) return false;
      if(sol[k]-sol[i]==k-i) return false;
    }
    return true;

  }
  void foo(int l, int n, int[] sol) {
    if(l==n) { num++; return; }
    for(int i=0;i<n;i++) {
      sol[l]=i;
      if(checkBoard(sol,l))
        foo(l+1,n,sol);
    }
  }
  public int totalNQueens(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] sol = new int[n];
    num=0;
    foo(0,n,sol);
    return num; 
  }
  public static void main(String[] args) {
    NQueenII nq = new NQueenII();
    System.out.println(nq.totalNQueens(4));
    System.out.println(nq.totalNQueens(6));
    System.out.println(nq.totalNQueens(8));
  }
}


