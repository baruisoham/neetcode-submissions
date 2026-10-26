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
        

        final ArrayList<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;


        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean oddLevel = false;

        while(!queue.isEmpty()){

            final int size = queue.size();
            final ArrayDeque<Integer> list = new ArrayDeque<>();
            for(int i=0; i<size; i++){

            //     TreeNode node;
            //      if(oddLevel) node = queue.pollLast();
            //      else node = queue.poll();
            //     if(node.right!=null) {
            //         if(oddLevel) queue.addFirst(node.right);
            //         else queue.add(node.right);
            //     }
            //     if(node.left!=null) {
            //         if(oddLevel) queue.addFirst(node.left);
            //         else queue.add(node.left);
            //     }
            //     list.add(node.val);

            // }

            // // if(!oddLevel) list.reverseOrder();
            // oddLevel = !oddLevel;
            // result.add(list);



            TreeNode node = queue.poll();
            if(!oddLevel) list.offer(node.val);
            if(oddLevel) list.offerFirst(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            }

            // if(!oddLevel) Collections.reverse(list);
            oddLevel = !oddLevel;

            result.add(new ArrayList<>(list));


        }

        return result;
    }
}