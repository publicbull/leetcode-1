public class Solution {
  void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i]=A[j];
    A[j]=t;
  }
  public int removeDuplicates(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int i=0,s=0,n=A.length,max=-100;
    while(i<n) {
      if(A[i]>max){
        max=A[i];
        swap(A,i,s);
        s++;
      }
      i++;
    }
    return s;
  }
  public int removeDuplicates(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length ==0) return 0;
    int n = A.length;
    int pre=A[0]; int cur = A[0];
    int j=1;
    for(int i=1;i<n;i++){
      cur = A[i];
      if(cur !=pre ){
        if ( i!=j)
          A[j]=A[i];
        j++;
        pre=cur;
      }
    } 
    return j; 
  }
}
