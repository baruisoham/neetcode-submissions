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
    private int k;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root){
        if(root==null || k<1) return;
        traverse(root.left);
        if(k==1) result = root.val;
        k--;
        traverse(root.right);
    }


}
