/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
  public:
    bool foo(TreeNode* r, int *h) {
      int lh=0,rh=0;
      if(r==NULL) {*h=0; return true;}
      bool lb=foo(r->left,&lh);
      bool rb=foo(r->right,&rh);
      *h=max(lh,rh)+1;
      return lb&&rb&&abs(lh-rh)<=1;
    }
    bool isBalanced(TreeNode *root) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      int h=0;
      return foo(root,&h);

    }
};
