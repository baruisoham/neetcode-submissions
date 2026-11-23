class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return assignChild(nums, 0, nums.length-1);
    }


    private TreeNode assignChild(int[] nums, int s, int e){

        if(s>e) return null;

        final int mid = s+((e-s)/2);
        final TreeNode node = new TreeNode(nums[mid]);

        node.left = assignChild(nums, s, mid-1);
        node.right = assignChild(nums, mid+1, e);

        return node;

    }
}
