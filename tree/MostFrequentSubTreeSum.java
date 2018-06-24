Map<Integer, Integer> map = new HashMap<>();
int max = 1;
public int[] findFrequentTreeSum(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    sum(root);
    Iterator<Integer> iter = map.keySet().iterator();
    while(iter.hasNext()){
        int key = iter.next();
        if(map.get(key) == max){
            list.add(key);
        }
    }        
    int[] ans = new int[list.size()];
    for(int i = 0; i < list.size(); i++){
        ans[i] = list.get(i);
    }
    return ans;        
}    
private int sum(TreeNode root){
    if(root == null) return 0;        
    int l = sum(root.left);
    int r = sum(root.right);
    int sum = l + r + root.val;
    if(map.keySet().contains(sum)){
        int temp = map.get(sum)+1;
        if(temp > max){
            max = temp;
        }
        map.put(sum, temp);
    }else{
        map.put(sum, 1);
    }
    return l + r + root.val;
}