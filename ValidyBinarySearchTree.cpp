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
    bool foo(TreeNode* r, int l, int h) {
      if(!r) return true;
      if(r->val <=l || r->val >= h) return false;
      return foo(r->left, l,r->val) && foo(r->right,r->val,h);
    }
    bool isValidBST(TreeNode *root) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      return foo(root, INT_MIN, INT_MAX);        

    }
};
