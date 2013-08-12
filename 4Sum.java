public class Solution {
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);
    if(num.length<4) return result;
    for(int i=0;i<num.length-3;i++) {
      for(int t=i+1;t<num.length-2;t++) {
        if(i!=0&&num[i]==num[i-1]||t!=i+1&&num[t]==num[t-1]) continue;
        int j=t+1, k=num.length-1;
        while(j<k) {
          int diff=target-num[i]-num[t]-num[j]-num[k];
          if(diff<0) k--;
          else if (diff>0) j++;
          else { 
            ArrayList<Integer> item = new ArrayList<Integer>();
            item.add(num[i]);item.add(num[t]);item.add(num[j]);item.add(num[k]);
            result.add(item);
            while(num[++j] == num[j-1] && j < k);  
            while(num[--k] == num[k+1] && k > j);  
          }
        }

      }
    }
    return result;

  }
  //fast
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
       ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer
>>();
        Set set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);

        for(int i=0;i<num.length-3;i++){
            for(int j=i+1;j<num.length-2;j++){
                int k=j+1,l=num.length-1;
                while(k<l){
                    if(num[i]+num[j]+num[k]+num[l]==target){
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[k]);
                        result.add(num[l]);
                        set.add(result);
                        k++;
                        l--;
                    }else if(num[i]+num[j]+num[k]+num[l]>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        list.addAll(set);
        return list;
  }
}
