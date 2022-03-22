Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag=new ArrayList<>();
        if(root==null)
            return zigzag;
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);
        int ch=1;
        
        while(!queue.isEmpty())
        {
            int level=queue.size();
            
            ArrayList<Integer> node=new ArrayList<>(); 
            for(int i=0;i<level;i++)
            {
                TreeNode cur=queue.poll();
                node.add(cur.val);
                
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
                
            }
            if(ch%2!=0)
            {
                zigzag.add(node);
            }
            else
            {
                Collections.reverse(node);
                zigzag.add(node);
            }
            ch++;
        }
        return zigzag;
    }
}
