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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        List<TreeNode> roots = new ArrayList<>();
        findNode(root, subRoot.val, roots);
        // if(rootTreeNode==null) return false;

        for(TreeNode rootTreeNode: roots){
            if(compareTrees(rootTreeNode, subRoot)) return true;
        }
        return false;

    }

    private boolean compareTrees(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;

        if(subRoot.val!=root.val) return false;
        return compareTrees(root.left, subRoot.left) && compareTrees(root.right, subRoot.right);
    }

    private void findNode(TreeNode root, int value, List<TreeNode> roots){
        if(root==null) return;
        if (root.val==value) roots.add(root);
        findNode(root.left, value, roots);
        findNode(root.right, value, roots);
    }




    // private void generateList(TreeNode root, List<Integer> result){
    //     if(root==null) return;
    //     result.add(root.val);
    //     generateList(root.left, result);
    //     generateList(root.right, result);

    // }
}
