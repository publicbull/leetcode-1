import java.io.*;
import java.util.*;

public class ListIncrement {
  void increment(ArrayList<Integer> al) {
    int l = al.size();
    int carry=1;
    for(int i=l-1;i>=0;--i) {
      int n = al.get(i).intValue()+carry; 
      if(n>9) {carry=1;n-=10;al.set(i,n);} 
      else {carry=0;al.set(i,n);break;}
    }
    if(carry==1) {
      al.add(0,1);
    }
  }
  static void printArray(ArrayList<Integer> al ) {
    for(int i:al) {
      System.out.print(i+" ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    al.add(9);
    al.add(9);
    al.add(9);
    new ListIncrement().increment(al);
    printArray(al);
  }
}
