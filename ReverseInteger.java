public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int r = 0;
        int s=1;
        if(x<0){s=-1;x*=-1;}
        while(x>0) {
            int d = x-x/10*10;
            r=r*10+d;
            x/=10;
        }
        return r*s;
    }
}
