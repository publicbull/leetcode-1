public class Solution {
  public int jump2(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int n = A.length;
    int i=0,cnt=0;
    while(i<n) {
      int max=0,maxj=0; 
      if(i>=n-1) return cnt;
      cnt++; 
      for(int j=1;j<=A[i];j++) {
        if((i+j)>=n-1) return cnt;
        if(max<(j+A[i+j])) {
          max=j+A[i+j];
          maxj=j;
        }
      }
      if(maxj==0) return 0;
      i+=maxj;
    }
    return cnt;

  }
}
