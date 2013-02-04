#include<stdio.h>
#include<stdlib.h>
#include"ylutil.h"

int foo(int A[], int f[], int n) {
  //check n <= 1
  int ret = 0;
  int totalweight = f[0];
  int i;
  for(i = 1; i < n; i++) {
    totalweight += f[i];
    int p = rand()%totalweight+1;
    if(p <= f[i]) ret = i;
  }
  return A[ret];
}

int main() {
  int f[]={40,30,20,10};
  int a[]={1,2,3,4};
  int n = sizeof(a)/sizeof(int);
  int i,j;
  srand ( time(NULL) );
  int cnt[5];
  memset(cnt,0,5*sizeof(int));
  for(j=0;j<100000;j++)
  for(i=0;i<n;i++) {
    int d = foo(a,f,n); 
    cnt[d]++; 
  }
  for(i=1;i<=n;i++) {
      printf("%d:%d\n", i,cnt[i]);
  }
}
