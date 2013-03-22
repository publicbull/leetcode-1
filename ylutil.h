#include<limits.h>
#include<string.h>
#define MAX(X,Y) (X)>(Y)?(X):(Y)
#define MIN(X,Y) (X)<(Y)?(X):(Y)

void swap(int *a, int x,int y) {
  int t=a[x];
  a[x]=a[y];
  a[y]=t;
}

void swap2int(int *x,int *y) {
  int t=*x;
  *x=*y;
  *y=t;
}

void init_array(int *a, int n, int val) {
  int i;
  for(i=0;i<n;i++) {
    a[i]=val;
  }
}

int int_max(int x,int y) {
  if(x>y)
    return x;
  else
    return y;
}
int int_max3(int x,int y,int z) {
  return MAX(MAX(x,y),z);
}
int int_min3(int x,int y,int z) {
  return MIN(MIN(x,y),z);
}

void print_array_w_index(int* a, int len,int printbase) {
  int i;
  for(i=0;i<len;i++) {
    printf("a[%d]:%d\t", i+printbase, a[i]);
  }
  printf("\n");
}
void print_array(int* a, int len) {
  int i;
  for(i=0;i<len;i++) {
    printf("%d\t", a[i]);
  }
  printf("\n");
}

void print_2darray(int* a, int len_x,int len_y) {
  int i,j;
  for(i=0;i<len_x;i++) {
    for(j=0;j<len_y;j++) {
      printf("a[%d][%d]:%d\t", i,j, a[i*len_x+j]);
    }
    printf("\n");
  }
}
void print_matrix(int** a, int len_x,int len_y) {
  int i,j;
  for(i=0;i<len_x;i++) {
    for(j=0;j<len_y;j++) {
      printf("a[%d][%d]:%d\t", i,j, a[i][j]);
    }
    printf("\n");
  }
}
int** createIntMatrix(int m, int n) {
  int* values = (int*)calloc(m*n, sizeof(int));
  int** rows = (int**)malloc(m*sizeof(int*));
  int i;
  for (i=0; i<m; ++i)
  {
    rows[i] = values + i*n;
  }
  return rows;
}

void destroyIntArray(int** arr)
{
    free(*arr);
    free(arr);
}
