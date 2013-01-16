#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<string>
#include<algorithm>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start=0,end=0,i,n=s.length(),max=0;
        int pos[26];
        memset(pos,-1,26*sizeof(int));
        for(i=0;i<n;i++) {
            if(pos[s[i]-'a']>=start)
                start=pos[s[i]-'a']+1;
            end=i;
            if(max<(end-start+1)) max=end-start+1;
            pos[s[i]-'a']=i; 
        }
        return max;
    }
};


int main(int argc, char* argv[]) {
  Solution s;
  string str = "inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating";
  cout << s.lengthOfLongestSubstring(str) << endl;
  return 1;
}
