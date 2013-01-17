#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

void foo(int n) {
  int i,j;
  for(i=1;i<1<<n;i++) {
    for(j=0;j<n;j++) 
      if(i>>j&0x1) printf("%d ", j);
    printf("\n");
  }
}

int main(int argc, char* argv[]) {
  foo(3);
  return 1;
}
