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
    int count = 0;

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        checkNode(root);
        return count;
    }

    private void checkNode(TreeNode currNode){
        if(currNode==null) return;
        final int prevMaxVal = maxVal;
        if(currNode.val>=maxVal) {
            count++;
            maxVal = currNode.val;
        }


        checkNode(currNode.left);
        checkNode(currNode.right);

        maxVal = prevMaxVal;

    }
}
