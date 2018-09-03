//Time complexity: O(V+E)
//Space complexity: O(V)
//I did BFS traversal to clone all the nodes in one traversal
//then I iterated over the clones map and added all the neighbors
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) return null;
	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
	Queue<UndirectedGraphNode> queue = new LinkedList<>();
	queue.add(node);
	while(!queue.isEmpty()){
		UndirectedGraphNode curr = queue.poll();
		if(!map.containsKey(curr)) map.put(curr, new UndirectedGraphNode(curr.label));
		UndirectedGraphNode newCurr = map.get(curr);
		newCurr.neighbors = new ArrayList<UndirectedGraphNode>();
		List<UndirectedGraphNode> nei = curr.neighbors;
		for(UndirectedGraphNode currNei : nei){
			if(!map.containsKey(currNei)) {
				queue.add(currNei); 
				map.put(currNei, new UndirectedGraphNode(currNei.label));
			}
			newCurr.neighbors.add(map.get(currNei));
		}
	}
	
	return map.get(node);
}