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


    int maxVal = Integer.MIN_VALUE;

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return checkNode(root);
    }

    private int checkNode(TreeNode currNode){
        if(currNode==null) return 0;
        final int prevMaxVal = maxVal;
        boolean isGoodNode = false;
        if(currNode.val>=maxVal) {
            maxVal = currNode.val;
            isGoodNode = true;
        }

        final int count = checkNode(currNode.left) + checkNode(currNode.right) + (isGoodNode ? 1 : 0);

        maxVal = prevMaxVal;
        return count;
    }
}
