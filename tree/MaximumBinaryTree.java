public TreeNode constructMaximumBinaryTree(int[] nums) {
    return util(nums, 0, nums.length);
}    
private TreeNode util(int[] nums, int i, int j){
    if(i == j) return null;
    int maxIndex = i;
    for(int k=i+1; k<j; k++){
        if(nums[k] > nums[maxIndex]){
            maxIndex = k;
        }
    }
    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = util(nums, i, maxIndex);
    root.right = util(nums, maxIndex+1, j);        
    return root;
}