#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

double findkth(int a[], int m, int b[], int n, int k)
{
    if (m > n) return findkth(b, n, a, m, k);

    if (m == 0) return b[k-1];
    if (k == 1) return MIN(a[0], b[0]);
    int pa = MIN(k/2, m), pb = k - pa;
    if (a[pa-1] < b[pb-1]) return findkth(a+pa, m-pa, b, n, k - pa);
    else if (a[pa-1]>b[pb-1]) findkth(a, m, b+pb, n-pb, k-pb);
    else {printf("equal %d\n", a[pa-1]); return a[pa-1];}
    /* same as 
    if (a[pa-1] < b[pb-1]) return findkth(a+pa, m-pa, b, n, k - pa);
    else return findkth(a, m, b+pb, n-pb, k-pb);
    */
}

int main(int argc, char* argv[]) {
  //int a[]={3,4,5,6,7};
  //int b[]={1,2,3};
  int a[]={100001};
  int b[]={100000};
  int m=1,n=1;
  int median=(m+n)/2;
  printf("median %d\n", median);
  if((m+n)%2) {
    int r= findkth(a,m,b,n,median+1);
    printf("odd %d\n", r);
  } else {
    int p= findkth(a,m,b,n,median);
    int q= findkth(a,m,b,n,median+1);
  
    printf("even %d %d %f\n", p,q,(p+q)/2.0);
  }
  return 1;
}
