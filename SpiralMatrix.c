#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

void printlayer(int**a,int m, int n, int k) {
  int i,j;
  for(i=k;i<n-k;i++) 
    printf("%d\t", a[k][i]);
  for(i=k+1;i<m-k-1;i++) 
    printf("%d\t", a[i][n-1-k]);
  for(i=n-k-1;i>=k;i--) 
    printf("%d\t", a[m-1-k][i]);
  for(i=m-k-2;i>=k+1;i--) 
    printf("%d\t", a[i][k]);
} 

int hit_boundary(int x,int y,int n,int **a) {
  if(x<0 || x> n-1 || y<0 || y>n-1 || a[x][y]!=0) return 1;
  return 0;
}

void fillmatrix(int** a, int n) {
  int i,x,y,dx,dy,nx,ny;
  x=0;y=0;dx=0;dy=1;
  for(i=0;i<n*n;i++) {
    printf("x=%d,y=%d,dx=%d,dy=%d:%d\n",x,y,dx,dy,i);
    a[x][y]=i+1;
    nx = x + dx; ny = y + dy;
    if (hit_boundary(nx,ny,n,a)) {
      printf("boundary\n");
      int t=dy;
      dy=-dx;
      dx=t;
      x+=dx;
      y+=dy;
    } else {
      x=nx;y=ny;
    }
  }
}

void testFill(int n) {
  int **a = createIntMatrix(n,n);
  fillmatrix(a,n);
  print_matrix(a,n,n);
}

void testPrint(int n) {
  int i,j,c=1;
  int m=3;
  int **a = createIntMatrix(m,n);
  int min = (m < n ? m : n);  
  int layer = min / 2+1;  

  for(i=0;i<m;i++) { 
    for(j=0;j<n;j++) {
      a[i][j]=c++;
    }
  }

  print_matrix(a,m,n);

  int k;
  for(k=0;k<layer/2;k++) {
    printlayer(a,m,n,k);
  }
  if(m%2) {
    if(m>n){
      for (i = layer-1; i <= m-1-layer; ++i)  
        printf("%d ",a[i][n/2]);  
    } else {
      for (i = layer-1; i <= n-1-layer; ++i)  
        printf("%d ",a[m/2][i]);  
    }
  }
  printf("\n");
  destroyIntArray(a);
}

int main(int argc, char* argv[]) {
  int n=4;
  if(argc>1) n=atoi(argv[1]);
  testPrint(n);
  return 1;
}
