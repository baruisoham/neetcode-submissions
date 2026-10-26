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
    public List<Integer> rightSideView(TreeNode root) {
        

        final List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
         
        while(!queue.isEmpty()){

            final int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                final TreeNode node = queue.poll();
                if(i==levelSize-1) result.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return result;
    }
}
