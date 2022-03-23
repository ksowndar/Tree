Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetric(root.left,root.right);
    }
    
    boolean isSymmetric(TreeNode left,TreeNode right)
    {
        if(left==null || right==null)
            return left==right;
        
        if(left.val != right.val)
            return false;
        
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
            
    }
}
