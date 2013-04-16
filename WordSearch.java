import java.io.*;
import java.util.*;

public class WordSearch {
  boolean search(char[][] m, String w, boolean[][] v,int i, int j, int pw) {
    if(pw==w.length()) return true;

    int d1=m.length;
    int d2=m[0].length;
    if(i<0||i>=d1||j<0||j>=d2||v[i][j]||m[i][j]!=w.charAt(pw))return false; 

    v[i][j]=true;
    if(search(m,w,v,i-1,j,pw+1)||search(m,w,v,i+1,j,pw+1)||search(m,w,v,i,j-1,pw+1)||search(m,w,v,i,j+1,pw+1)) {
      return true; 
    }
    v[i][j]=false;
    return false; 
  }
  boolean foo(char[][] m, String w) {
    int d1 = m.length;
    int d2 = m[0].length;
    boolean[][] v = new boolean[d1][d2];
      
    for(int i=0;i<d1;++i)
      for(int j=0;j<d2;++j) {
        if(search(m,w,v,i,j,0)) {
          return true;
        }
      }
    return false;
  }
  public static void main(String[] args) {
    //char[][] m={{'S','M','E','F'},{'R','A','T','D'},{'L','O','N','I'},{'K','A','F','B'}};
    char[][] m={{'a','b'},{'c','d'}};
    String word="acdb";
    System.out.println(new WordSearch().foo(m,word));
  }
}
