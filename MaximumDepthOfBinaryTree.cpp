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
    int foo(TreeNode *n) {
      if(n==NULL) return 0;
      return max(foo(n->left)+1, foo(n->right)+1);
    }
    int maxDepth(TreeNode *root) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      return foo(root);

    }
};
