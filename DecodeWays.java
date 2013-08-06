public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(s.length()==0) return 0;
       int rlt =_numDecodings(s);

       return rlt;
   }
   
   
   public int _numDecodings(String s){
       int l=s.length();
       int[] ways = new int[l+1];
       
       ways[0]=1;
        int v = Integer.parseInt(s.substring(0,1));
       if(v==0)
           ways[1]= 0;
       else
           ways[1] =1;
       

       
       for(int i=2;i<l+1;i++){        
           String prefix;
           prefix = s.substring(i-2,i);
            v = Integer.parseInt(prefix);
           if(v<=26&&v>0 && !prefix.startsWith("0")){
               ways[i]=ways[i-2];
           }else{
               ways[i]=0;
           }  
           
           prefix = s.substring(i-1,i);
           if(!prefix.equals("0")){
               ways[i] +=ways[i-1];
           }            
           
           
       }
       
       return ways[l];
   }
}

