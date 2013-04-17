public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a=1,b=1;
        for(int i=2;i<=n;i++) {
            b=a+b;
            a=b-a;
        }
        return b;
    }
}
