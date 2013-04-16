public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        if(num.length<3) return result;
        int target=0;
        for(int i=0;i<num.length-2;i++) {
            int j=i+1, k=num.length-1;
            if(i>0&&num[i]==num[i-1])continue;
            while(j<k) {
                int diff=target-num[i]-num[j]-num[k];
                if(diff<0) k--;
                else if (diff>0) j++;
                else { 
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);item.add(num[j]);item.add(num[k]);
                    result.add(item);
                    while(num[++j] == num[j-1] && j < k);  
                    while(num[--k] == num[k+1] && k > j);  
                }
            }
            
        }
        return result;
        
    }

    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int diff=100000;
        int rc=0;
        for(int i=0;i<num.length;i++) { 
            for(int j=i+1,k=num.length-1;j<k;) {
                int sum=num[i]+num[j]+num[k];
                //or use abs
                if(sum <target) {
                    j++;
                    if(diff>target-sum) {
                        diff = target-sum;
                        rc = sum;
                    }
                } else if (sum > target) {
                    k--;
                    if(diff>sum-target) {
                        diff = sum-target;
                        rc = sum;
                    }
                } else {
                    return target;
                }
            }
        }
        return rc;
        
    }
}
