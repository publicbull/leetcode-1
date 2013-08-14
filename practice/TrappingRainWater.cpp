class Solution {
public:
    int trap(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int leftMax[n],maxsofar=0,sum=0;
        for(int i=0;i<n;i++) {
            leftMax[i]=maxsofar;
            if(maxsofar<A[i]) maxsofar=A[i];
        }
        maxsofar=0;
        for(int i=n-1;i>=0;i--) {
            sum+=max((min(leftMax[i], maxsofar)-A[i]),0);
            if(maxsofar<A[i]) maxsofar=A[i];
        }
        return sum;
    }
};
