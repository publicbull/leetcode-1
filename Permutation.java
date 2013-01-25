public class Solution {
  void swap(int[] num,int x,int y) {
    int t = num[x];
    num[x]=num[y];
    num[y]=t;
  }
  void foo(int[] num, ArrayList<ArrayList<Integer>> result,int l) {
    int n=num.length;
    if(l==n) {
      ArrayList<Integer> item = new ArrayList<Integer>();
      for(int i=0;i<n;i++) {
        item.add(num[i]);
      }
      result.add(item);
    }
    for(int i=l;i<n;i++) {
      swap(num,l,i);
      foo(num,result,l+1);
      swap(num,l,i);
    }
  }
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>> ();
    foo(num,result,0);
    return result;
  }
}
