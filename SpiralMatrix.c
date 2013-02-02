#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"../ylutil.h"

void printlayer(int**a,int m, int n, int k) {
  int i,j;
  for(i=k;i<n-k;i++) 
    printf("%d\t", a[k][i]);
  for(i=k+1;i<n-k;i++) 
    printf("%d\t", a[i][n-1-k]);
  for(i=n-k-2;i>=k;i--) 
    printf("%d\t", a[n-1-k][i]);
  for(i=n-k-2;i>=k+1;i--) 
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

int main(int argc, char* argv[]) {
  int n=4,i,j,c=1;
  if(argc>1) n=atoi(argv[1]);
  int **a = createIntMatrix(n,n);
  for(i=0;i<n;i++) { 
    for(j=0;j<n;j++) {
      //a[i][j]=c++;
      //a[i][j]=-1;
    }
  }

  print_matrix(a,n,n);

  int k;
  fillmatrix(a,n);
  for(k=0;k<n/2;k++) {
  }
  if(n%2) {
    printf("%d\t",a[n/2][n/2]);
  }
  print_matrix(a,n,n);
  printf("\n");
  destroyIntArray(a);
  return 1;
}
