#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

int firstMissingPositive(int* A,int n) {
  int i;
  for (i=0; i<n; ++i) {
    while (1<=A[i] && A[i] <=n && A[A[i]-1]!=A[i])  {
    //above is better than while (1<=A[i] && A[i] <=n && i!=A[i]-1)  {
      swap(A,i, A[i]-1);
    }
  }

  for (i=0; i<n; ++i)
    if (A[i] != i+1)
      return i+1;

  return n+1;   
}
int main(int argc, char* argv[]) {
  int a[]={3,4,-1,1};
  int m = firstMissingPositive(a,4);
  printf("%d\n",m);
  return 1;
}
