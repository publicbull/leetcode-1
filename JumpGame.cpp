#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<string>
#include<algorithm>

using namespace std;

/*
I dont have proof for this greedy method, altho it passes all the test cases
*/

class Solution {
  public:
    bool canJump(int A[], int n) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int i=0,max=0,jumpcnt=0;
      while(i<n){
        jumpcnt++;
        max=i;
        for(int j=1;j<=A[i];j++) {
          if(max<(i+j+A[i+j])) max=i+j+A[i+j];
        }
        if(max==i&&i<n-1) return false;
        if(max>=n-1) return true;
        i=max; 
      }
      return false; 
    }
};

int main(int argc, char* argv[]) {
  Solution s;
  int a[]={2,1,1,2,1,0,1};
  cout << s.canJump(a,7) << endl;
  return 1;
}
