//we generate the graph and do a bfs on all the nodes
//while doing bfs we keep track of all the visited nodes and 
//increase the count if current starting node is not in visited
//Time complexity: O(V+E) here V is n and E is length of edges
//Space complexity: O(V+E)
public int countComponents(int n, int[][] edges) {
	Map<Integer, Set<Integer>> graph = new HashMap<>();
	for(int i = 0; i < n; i++){
		graph.put(i, new HashSet<Integer>());
	}

	for(int[] edge : edges){
		graph.get(edge[0]).add(edge[1]);
		graph.get(edge[1]).add(edge[0]);
	}

	Set<Integer> visited = new HashSet<>();
	int count = 0;
	for(int i = 0; i < n; i++){
		if(!visited.contains(i)){
			count++;
			bfs(i, graph, visited);
		}
	}
	return count;
}

private void bfs(int vertex, Map<Integer, Set<Integer>> graph, Set<Integer> visited){
	visited.add(vertex);
	Queue<Integer> queue = new LinkedList<>();
	queue.add(vertex);
	while(!queue.isEmpty()){
		Set<Integer> nei = graph.get(queue.poll());
		for(int curNei : nei){
			if(!visited.contains(curNei)){
				queue.add(curNei);
				visited.add(curNei);
			}
		}
	}
	return;
}