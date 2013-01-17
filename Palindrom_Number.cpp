class Solution {
  public:
    bool isPalindrome(int x) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      if(x>=0&x<10) return true;
      if(x<0) return false;
      int d=1;
      while(x/d>=10) {
        d*=10;
      }
      int b,e;
      while(x>=10) {
        e=x%10;
        b=x/d;
        if(e!=b) return false;
        x=x%d/10;   
        d/=100;
      }
      return true; 
    }
};
