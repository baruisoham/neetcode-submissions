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
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }
    private void preorder(List<Integer> list, TreeNode root){
        if(root==null) return;

        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
}