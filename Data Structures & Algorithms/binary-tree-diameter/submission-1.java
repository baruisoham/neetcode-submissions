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
    private Integer maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode node) {
        dfs(node);
        return maxDiameter-1;   
    }


    // public void diameter(TreeNode node){
    //     if(node==null) return;
    //      maxDiameter = Math.max(dfs(node.left) + dfs(node.right) + 1, maxDiameter);
    //     diameter(node.left);
    //     diameter(node.right);
    // }

    public int dfs(TreeNode node){
        if (node==null) return 0;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        maxDiameter = Math.max(leftDepth + rightDepth + 1, maxDiameter);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
