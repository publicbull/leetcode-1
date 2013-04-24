import java.io.*;
import java.util.*;

public class RestoreIPAddress {


  boolean valid(String s) {
    try {
      if(s.startsWith("0") && s.length()>1) return false;
      int i = Integer.parseInt(s);
      if(i>0&&i<=255) 
        return true;
      return false;
    } catch (Exception e) {
      return false;
    }
  }
  String print_array(int[] a,String s) {
    int st=0;
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<a.length;i++) {
      sb.append(s.substring(st,st+a[i])); 
      st+=a[i];
    }
    return sb.toString();
  }

  void foo(String o_s, String s, int i,int[] a, int n, ArrayList<String> arr) {
    if(i==n&&s.equals("")) {
      arr.add(print_array(a,o_s));
      return;
    }else if(i==n) {
      return;
    }

    int l = s.length();
    for(int j=1;j<=l;j++) {
      String sub=s.substring(0,j);
      if(valid(sub))  {
        a[i]=j;
        String sub2 = s.substring(j);
        foo(o_s,sub2,i+1,a,n,arr);
      }   
    }
  }
  public ArrayList<String> restoreIpAddresses(String s) {
    int[] a = new int[4];
    ArrayList<String> arr = new ArrayList<String>(); 
    foo(s,s,0,a,4, arr);
    return arr;

  }
  public static void main(String[] args) {
    new RestoreIPAddress().restoreIpAddresses("25525511135");
  }
}
