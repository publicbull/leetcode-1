#include<iostream>
using namespace std;

class Solution {
  public:
    int maxSubArray(int A[], int n) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      if(n<1) return 0;
      int sum[n];
      sum[0]=A[0];
      for(int i=1;i<n;i++) {
        int tmp=sum[i-1]+A[i];
        sum[i]=tmp>A[i]?tmp:A[i];
      }
      int max=sum[0];
      for(int i=1;i<n;i++) {
        if(max<sum[i])max=sum[i];
      }
      return max; 
    }
};

int main() {
  Solution s;
  int A[]={1,2};
  cout << s.maxSubArray(A,2) << endl;
}
