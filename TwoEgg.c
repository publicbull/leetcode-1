#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

/*
2 eggs: F(i)=MIN{MAX{F(i-j)+1,j}} 1<=j<=i
n eggs, k floors: W(n,k) = 1 + min{max(W(n − 1, x − 1), W(n,k − x)): x in {1, 2, ..., k}}, n = 2, ..., N; k = 2, 3, 4, ..., H
see ref: http://en.wikipedia.org/wiki/Dynamic_programming#Egg_dropping_puzzle
*/
int foo(int n) {
  int dp[n+1];
  int i,j;
  dp[0]=0;
  for(i=1;i<=n;i++) {
    int min=INT_MAX;
    for(j=1;j<=i;j++) {
      int max=MAX(dp[i-j]+1,j);
      if(min>max)min=max;
    }
    dp[i]=min;
  }
  return dp[n];
}

int main(int argc, char* argv[]) {
  int r = foo(100);
  int i;
  for(i=0;i<200;i++) 
    printf("%d:%d\n", i,foo(i));
  return 1;
}
