public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0,n=str.length(),sign=1;
        long r=0;
        while(i<n&&str.charAt(i)==' ') i++;
        if(i>=n) return 0;
        
        if(str.charAt(i)=='-') {sign=-1;i++;}
        else if(str.charAt(i)=='+'){i++;}
        
        while(i<n) {
            char c = str.charAt(i);
            if(c>='0'&&c<='9') {
            int d=str.charAt(i)-'0';
                r=r*10+d;
                if(sign==-1&&r-1>Integer.MAX_VALUE) return Integer.MIN_VALUE;
                if(sign==1&&r>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else break;
            i++;
        }
        return (int)(sign*r);
    }
}
