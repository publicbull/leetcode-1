#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"ylutil.h"

void _dfs(int a[][6],int n,  int *c, int s) {
  int i;
  if(c[s]!=0) {printf("found a backedge: %d\n",s+1);return;}
  c[s]=1;
  printf("visiting node %d\n", s+1);
  for(i=0;i<n;++i) { 
    if(s==i)continue;
    if(a[s][i]!=-1)
      _dfs(a,n,c,i);
  }
  c[s]=2;
}

void dfs(int a[][6],int n, int s) { 
  //color: 0 never visited 1 being visited 2 finished visiting
  int c[n];
  init_array(c,n,0);
  _dfs(a,n,c,s);
  print_array_w_index(c,n,1);
}

//s: current node
void _dfs_allpath(int a[][6],int n, int s,int * path,int *v,int c) { 
  if(c==n) {
    print_array_w_index(path,n,1);
    return;
  }
  int i;
  for(i=0;i<n;++i) { 
    if(s==i)continue;
    if(a[s][i]!=-1&&!v[i]) {
      path[c]=i+1;
      v[i]=1;
      _dfs_allpath(a,n,i,path,v,c+1);
      v[i]=0;
    }
  }
}

void dfs_allpath(int a[][6],int n, int s) { 
  int path[n]; 
  int v[n]; 
  init_array(v,n,0);
  path[0]=s+1;
  v[0]=1;
  _dfs_allpath(a,n,s,path,v,1);
}

void dijkstra(int a[][6],int m,int n, int s) {
  int v[n],b[n],prev[n];
  int i,j;
  init_array(v,n,0);
  init_array(b,n,-1);
  
  //init distance to itself to be 0
  b[0]=0;
  prev[0]=0;
  for(i=0;i<n;i++) {
    //for each of its neighbors
    for(j=0;j<n;j++) {
      //we have visited node i
      if(v[i]) continue;
      //not reachable
      if(a[i][j]==-1) continue;
      //first time getting to this neighbor
      if(b[j]==-1) {
        b[j]=a[i][j]+b[i];
        prev[j]=i+1;
      } else {
        //o.w., compare its current distance to the new one
        int newd=b[i]+a[i][j];
        if(newd<b[j]) {
          b[j]=newd;
          prev[j]=i+1;
        }
      }
    }
    //mark node i as visited
    v[i]=1;
  }
  printf("distance from node 0:\n");
  print_array_w_index(b,n,1);
  printf("prev node:\n");
  print_array_w_index(prev,n,1);
}

int main(int argc, char* argv[]) {
  int a[6][6]={{0,7,9,-1,-1,14},{7,0,10,15,-1,-1},{9,10,0,11,-1,2},{-1,15,11,0,6,-1},{-1,-1,-1,6,0,9},{14,-1,2,-1,9,0}};
  //dijkstra(a,6,6,0);
  dfs_allpath(a,6,0);
  return 1;
}
