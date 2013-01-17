#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<string>
#include<cstring>
#include<algorithm>

using namespace std;


class Solution {
  public:

    string longestPalindrome1(string s) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int nSize = s.size();
      if (nSize == NULL)  return "";

      int length = 1;
      const char* ps = s.c_str();
      const char* pstart = ps;
      const char* result = ps;
      while(*ps != '\0')
      {
        // odd
        const char *p1 = ps - 1;
        const char *p2 = ps + 1;
        while(p1 >= pstart && *p2 != '\0' && *p1 == *p2)
        {
          --p1;
          ++p2;
        }

        int tmp = p2 - p1 - 1;
        if (tmp > length)
        {
          length = tmp;
          result = p1 + 1;
        }

        // even
        p1 = ps;
        p2 = ps + 1;
        while(p1 >= pstart && *p2 != '\0' && *p1 == *p2)
        {
          --p1;
          ++p2;
        }

        tmp = p2 - p1 - 1;
        if (tmp > length)
        {
          length = tmp;
          result = p1 + 1;
        }

        ++ps;
      }

      return s.substr(result - pstart, length);
    }


    string longestPalindrome(string s) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int dp[1000][1000];
      int max=1;
      int begin=0;
      memset(dp,0,sizeof(int)*1000000);
      int n=s.length();
      for(int i=0;i<n;i++) {
        dp[i][i]=1;
        begin=i;
      }
      for(int i=0;i<n-1;i++) {
        if(s[i]==s[i+1]){dp[i][i+1]=1;max=2;begin=i;}
      }

      for(int len=3;len<=n;len++) {
        for(int i=0;i<n-len+1;i++) {
          int j=i+len-1;
          if(s[i]==s[j]&&dp[i+1][j-1]==1) {
            dp[i][j]=1;
            max=j-i+1;
            begin=i;
          }
        }
      }
      return s.substr(begin,max);


    }
};


int main(int argc, char* argv[]) {
  Solution s;
  cout << s.longestPalindrome("edccde") << endl;
  return 1;
}
