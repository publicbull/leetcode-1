public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String big=a,small=b;
        int lb=big.length(), ls=small.length();
        if(lb<ls) {
            big=b;
            small=a;
            lb=big.length();
            ls=small.length();
        }
        int c=0,i=0;
        StringBuffer buf = new StringBuffer();
        for(;i<ls;i++) {
            int c1 = big.charAt(lb-i-1)-'0';
            int c2 = small.charAt(ls-i-1)-'0';
            int s = c1+c2+c;
            if(s>=2) {
                s-=2;
                c=1;
            } else {
                c=0;
            }
            buf.append(s+"");
        }
        for(;i<lb;i++) {
            int c1 = big.charAt(lb-i-1)-'0';
            int s = c1+c;
            if(s>=2) {
                s-=2;
                c=1;
            } else {
                c=0;
            }
            buf.append(s+"");
        }
        if(c==1) buf.append("1");
        return buf.reverse().toString();
    }
}
