List<Integer> ans = new ArrayList<>();
int curCount = 0;
int maxCount = 0;
int curValue = 0;
public int[] findMode(TreeNode root) {
    dfs(root);
    int[] ret = new int[ans.size()];
    for(int i = 0; i < ans.size(); i++){
        ret[i] = ans.get(i);
    }
    return ret;
}    
private void handle(TreeNode root){
    if(root.val != curValue){
        curValue = root.val;
        curCount = 0;
    }
    curCount++;
    if(curCount > maxCount){
        ans = new ArrayList<>();
        maxCount = curCount;
        ans.add(curValue);                
    }
    else if(curCount == maxCount){
        ans.add(curValue);
    }
}    
private void dfs(TreeNode root){
    if(root == null) return;
    dfs(root.left);
    handle(root);
    dfs(root.right);
}