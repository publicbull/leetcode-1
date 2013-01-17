/* reversed int might overflow */
class Solution {
public:
    int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int sign=x>0?1:-1,r=0;
        if(sign==-1) x*=-1;
        while(x>=10) {
            int d= x -x/10*10;
            x/=10;
            r=r*10+d;
        }
        r=r*10+x;
        return r*sign;
    }
};
