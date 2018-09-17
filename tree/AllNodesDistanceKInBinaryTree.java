//Idea here is to simulate a dfs on tree
//Time complexity: O(n) where n is the number of nodes
//Space complexity: o(n) for graph
public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
	generateGraph(graph, root);
	List<Integer> res = new ArrayList<>();
	dfs(graph, target, K, 0, new HashSet<TreeNode>(), res);
	return res;
}

private void generateGraph(Map<TreeNode, Set<TreeNode>> graph, TreeNode root){
	if(root == null) return;
	if(!graph.containsKey(root)) graph.put(root, new HashSet<TreeNode>());
	if(root.left != null){
		if(!graph.containsKey(root.left)) graph.put(root.left, new HashSet<TreeNode>());
		graph.get(root).add(root.left);
		graph.get(root.left).add(root);
		generateGraph(graph, root.left);
	}
	if(root.right != null){
		if(!graph.containsKey(root.right)) graph.put(root.right, new HashSet<TreeNode>());
		graph.get(root).add(root.right);
		graph.get(root.right).add(root);
		generateGraph(graph, root.right);
	}
}

private void dfs(Map<TreeNode, Set<TreeNode>> graph, TreeNode node, int K, int curDepth, Set<TreeNode> visited, List<Integer> result){
	visited.add(node);
	if(K == curDepth) {
		result.add(node.val);
		return;
	}
	Set<TreeNode> nei = graph.get(node);
	for(TreeNode curNei: nei){
		if(!visited.contains(curNei)){
			dfs(graph, node, K, curDepth+1, visited, result);
			visited.remove(curNei);
		}
	}
}