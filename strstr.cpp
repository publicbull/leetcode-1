#include<iostream>
#include<cstdio>

using namespace std;

class Solution {
  public:
    char *strStr(char *haystack, char *needle) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      if(!*needle) return haystack;
      if(!*haystack) return NULL;
      while(*haystack) {
        char* s = haystack, *p=needle;
        while(*s&&*p&&*s==*p){ s++;p++; }
        if(!*p) return haystack;
        haystack++;
      }
      return NULL;

    }

    char *kmp(char *haystack, char *needle) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int nLen = strlen(needle);
      int* fail = new int[nLen];
      memset(fail, -1, nLen*sizeof(int));
      int i, j, k;
      for (i = 1; i < nLen; ++i)
      {
        for (k = fail[i-1]; k >= 0 && needle[i] != needle[k+1]; k = fail[k]);
        if (needle[k+1] == needle[i])
          fail[i] = k + 1;
      }
      i = j = 0;
      while(haystack[i] && needle[j])
      {
        if (haystack[i] == needle[j])
        {
          ++i;
          ++j;
        }
        else if(j == 0) ++i;
        else j = fail[j-1] + 1;
      }
      delete fail;
      if (needle[j]) return NULL;
      else return haystack + i - j;
    }
};

int main() {
  Solution s;
  char* r= s.strStr((char*)"mississippi",(char*)"mississippi");
  if(*r) cout << r << endl; 
}
