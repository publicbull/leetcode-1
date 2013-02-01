#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

//use dp to compute combination(n,k)

//c(n,k)=c(n-1,k)+c(n-1,k-1)

int foo(int n, int k) {
  int dp[n+1][k+1];
  int i,j;
  dp[0][0]=1;
  for(j=1;j<=k;j++) {
    dp[0][j]=0;
  }
  for(i=0;i<=n;i++) {
    dp[i][0]=1;
  }
  for(i=1;i<=n;i++) {
    for(j=1;j<=k;j++) {
      int p=j>=i?0:dp[i-1][j];
      int q=j>=i+1?0:dp[i-1][j-1];
      dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
      printf("n=%d k=%d : %d\n", i,j,dp[i][j]);
    }
  }
  return dp[n][k];
}

int main(int argc, char* argv[]) {
  int r = foo(20,7);
  printf("%d\n", r);
  return 1;
}
