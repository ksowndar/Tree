Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder=new ArrayList<>();
        if(root==null)
            return levelOrder;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            ArrayList<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                level.add(curr.val);
                
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}
