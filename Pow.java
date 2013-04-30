public class Solution {
    public double pow(double x, int n) {
        boolean odd=(n%2==1)?true:false;
        if(n==0.0) return 1.0;
        if(x==0.0) return 0;
        if(n==1.0) return x;
        
        if(x==1.0) return 1.0;
        if(x==-1.0) return odd?-1.0:1.0;
        if(n<0) return 1.0/pow(x,-n);
        
        
        double x1=x;
        double r=1.0;
        while(n>0) {
            if(n%2==1) r*=x;
            x*=x;
            n>>=1;
        }
        return r;
    }

    /* slower recursion version */
    public double pow2(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return 1.0;
        if(x==0.0||x==1.0) return x;
        if(x==-1.0) return (n%2==0)?1.0:-1.0;
        
        
        if(n<0) return 1.0/pow1(x,-n);
        else return pow1(x,n); 
    }
    double pow1(double x, int n) {
        if(n==1) return x;
        double r = pow1(x,n/2);
        return (n/2==(float)n/2.0)?r*r:r*r*x;
    }
}
