import java.io.*;
import java.util.*;

public class RestoreIPAddress {
    void foo(String s, int l, int n, ArrayList<String> res, String[] path) {
        if(s.length()>3*(n-l)) return;
        if(l==n&&s.length()==0) {
            StringBuffer buf = new StringBuffer();
            for(int i=0;i<n-1;i++) {
                buf.append(path[i]+".");    
            }
            buf.append(path[n-1]);
            res.add(buf.toString());
            return;
        }
        for(int i=1;i<=3;i++) {
            if(s.length()<i) return;
            String substr = s.substring(0,i);
            if(substr.startsWith("0")&&substr.length()>1) break;
            if(Integer.parseInt(substr)>255) break;
            path[l]=substr;
            foo(s.substring(i),l+1,n,res, path);
        }
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String>  res =new ArrayList<String> ();
        String[] path = new String[4];
        foo(s,0,4,res,path);
        return res;   
    }

  public static void main(String[] args) {
    new RestoreIPAddress().restoreIpAddresses("25525511135");
  }
} 
