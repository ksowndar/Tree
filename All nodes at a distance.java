Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void markParent(Map<TreeNode,TreeNode> parent_track,TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode currNode=queue.poll();
            if(currNode.left!=null)
            {
                parent_track.put(currNode.left,currNode);
                queue.offer(currNode.left);
            }
            if(currNode.right!=null)
            {
                parent_track.put(currNode.right,currNode);
                queue.offer(currNode.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        markParent(parent_track,root);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int currlevel=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            if(currlevel==k)
                break;
            currlevel++;
            for(int i=0;i<size;i++)
            {
                TreeNode currNode=queue.peek();
                queue.remove();
                if(currNode.left!=null && visited.get(currNode.left)==null)
                {
                    queue.offer(currNode.left);
                    visited.put(currNode.left,true);
                }
                if(currNode.right!=null && visited.get(currNode.right)==null)
                {
                    queue.offer(currNode.right);
                    visited.put(currNode.right,true);
                }
                if(parent_track.get(currNode)!=null && visited.get(parent_track.get(currNode))==null )
                {
                    queue.offer(parent_track.get(currNode));
                    visited.put(parent_track.get(currNode),true);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty())
        {
            TreeNode currNode=queue.poll();
            res.add(currNode.val);
        }
        return res;
    }
}
