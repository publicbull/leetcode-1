public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s="1";
        for(int i=1;i<n;i++) {
            char prev=s.charAt(0);
            char cur=prev;
            int cnt=1;
            StringBuffer sb = new StringBuffer();
            for(int j=1;j<s.length();j++) {
                if(prev!=s.charAt(j)) {
                    sb.append(""+cnt+cur);
                    prev=s.charAt(j);
                    cur=s.charAt(j);
                    cnt=1;
                } else cnt++;
            }
            sb.append(""+cnt+cur);
            s = sb.toString();
        }
        return s;
    }
}
