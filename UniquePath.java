import java.io.*;
import java.util.*;

public class uniquepath {

  public int uniquePaths(int m, int n) {
    int[][] L = new int[m][n];
    if(m==0||n==0) return 1;

    for(int i=0;i<m;i++) {
      L[i][0]=1;
    }
    for(int i=0;i<n;i++) {
      L[0][i]=1;
    }
    for(int i=1;i<m;i++) {
      for(int j=1;j<n;j++) {
        L[i][j]=L[i-1][j]+L[i][j-1];
      }
    }
    return L[m-1][n-1];


  }

  public static void main(String[] args) {
    int r=new uniquepath().uniquePaths(3,3);
    System.out.println(r);
  }
}
