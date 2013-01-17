class Solution {
  public:
    int atoi(const char *str) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      char* s = (char*)str;
      if(!*s) return 0;
      long long r=0; int sign=1;
      while(*s&&*s==' ')s++;
      if(*s&&*s=='+') {s++;sign=1;}
      else if(*s&&*s=='-'){s++;sign=-1;}
      while(*s) {
        if(*s>='0'&&*s<='9') {
          r=r*10+*s-'0';
        } else break;
        s++;
      }

      if(sign==-1&&r-1>=INT_MAX) return INT_MIN;
      if(r>INT_MAX) return INT_MAX;
      return (int)(r*sign);
    }
};
