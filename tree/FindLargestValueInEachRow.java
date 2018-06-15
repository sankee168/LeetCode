public List<Integer> largestValues(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if(root == null) return ans;
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue1.add(root);
    int maxValue = Integer.MIN_VALUE;
    while(!queue1.isEmpty()){
        TreeNode curr = queue1.remove();
        if(curr.left != null){
            queue2.add(curr.left);
        }
        if(curr.right != null){
            queue2.add(curr.right);
        }
        if(curr.val > maxValue){
            maxValue = curr.val;
        }            
        if(queue1.isEmpty()){
            ans.add(maxValue);
            maxValue = Integer.MIN_VALUE;
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
    }        
    return ans;
}

//Solution 2 recursive. Time Complexity O(n) Space Complexity O(n)
List<Integer> ans = new ArrayList<>();

public List<Integer> largestValues(TreeNode root){
    if(root == null) return ans;
    largest(root, ans, 0);
    return root;
}

private void largest(TreeNode root, List<Integer> list, int level){
    if(root == null) return;
    if(level >= list.size()){list.add(root.val);}
    list.set(level, Math.max(root.val, list.get(level)));

    larget(root.left, list, level+1);
    larget(root.right, list, level+1);
}