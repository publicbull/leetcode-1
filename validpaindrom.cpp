#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i=0,j=s.length()-1;
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        if(j==-1) return true;
        while(i<j) {
            while(s[i]&&!isalnum(s[i])) i++; 
            while(s[j]&&!isalnum(s[j])) --j;
            if(i>=j) break;
            if(s[i]!=s[j]) return false;
            i++;
            --j;
        }
        return true;
        
    }
};

int main() {
  Solution s;
  //cout << s.isPalindrome("1abcb2a");
  cout << s.isPalindrome(".,");
  cout << s.isPalindrome("a.");
  cout << s.isPalindrome("1a2");
}
