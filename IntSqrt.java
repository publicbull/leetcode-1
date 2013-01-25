public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long l=0,r=x/2,m=x/2;
        if(x==0||x==1) return x;
        while(l<=r) {
            m=(l+r)/2;
            long m2=m*m;
            long m12=(m+1)*(m+1);
            if(m2<=x &&x<m12) return (int)m;
            if(m2<x) {
                l=m+1;
            } else{
                r=m-1;
            }
        }
        return (int)m; 
    }
}
