#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

/* inclusive */
int parition(int *a, int l, int r) {
  int m=(l+r)/2;
  int pn=a[m],i=l,s=l;
  swap(a,m,r);
  while(i<r) {
    if(a[i]<pn) {
      swap(a,i,s);
      ++s;
    }
    ++i;
  }
  swap(a,s,r);
  return s;
}

void foo(int *a, int l, int r, int k) {
  if(l==r&&l==k) {printf("%d\n", a[k]);return;}
  if(l>=r) return;
  int pivot = parition(a,l,r); 
  if(pivot==k) {printf("%d\n", a[pivot]);}
  else if(pivot<k) {
    foo(a,pivot+1,r,k);
  } else {
    foo(a,l,pivot-1,k);
  }
}

int main(int argc, char* argv[]) { 
  int a[]={25, 99, 56, 25, 49, 0, 57, 3, 49, 55, 2, 28, 95, 43, 45, 15, 89, 58, 33, 10, 47, 46, 86, 24, 24, 74, 12, 26, 30, 87, 40, 6, 73, 50, 66, 96, 98, 58, 35, 47, 25, 78, 74, 25, 82, 11, 8, 16, 20, 17};
  int n=sizeof(a)/sizeof(int);
  int i;
  int* b = (int*)malloc(sizeof(int)*n);
  int k;
  for(k=1;k<=n;k++) {
    memcpy(b,a,n*sizeof(int));
    foo(b,0,n-1,k-1);
  }
  free(b);
  return 1;
}
