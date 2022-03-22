Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 
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
    public TreeNode balanceBST(TreeNode root) 
    {
        if(root == null)
            return null;
        List<TreeNode> inOrder=new ArrayList<>();
        callInorder(root,inOrder);
        return balanceTree(0,inOrder.size()-1,inOrder);
    }
    
    public void callInorder(TreeNode root,List<TreeNode> inOrder)
    {
        if(root == null)
            return;
        
        callInorder(root.left,inOrder);
        inOrder.add(root);
        callInorder(root.right,inOrder);
    }
    public TreeNode balanceTree(int start,int end,List<TreeNode> inOrder)
    {
        if(start>end)
            return null;
        
        int mid=(start+end)/2;
        TreeNode root=inOrder.get(mid);
        root.left=balanceTree(start,mid-1,inOrder);
        root.right=balanceTree(mid+1,end,inOrder);
        return root;
    }
}
