//Lets look at the properties of tree
//All the vertices are connected, pick any node and traverse through it it should visit all the nodes in the tree
//There are no cycles
//number of edges == vertices-1
//So this gives a clear picture, we have to check for cycle and check if all the nodes are visited
//Time complexity: O(V+E)
//Space complexity: O(V+E)
public boolean validTree(int n, int[][] edges) {
	Map<Integer, List<Integer>> map = new HashMap<>();
	for(int i = 0; i < n; i++){
		map.put(i, new ArrayList<Integer>());
	}
    
    int count = 0;
	for(int i = 0; i < edges.length; i++){
		map.get(edges[i][0]).add(edges[i][1]);
		map.get(edges[i][1]).add(edges[i][0]);
        count++;
	}
        
    if(count != n-1) return false;
    Set<Integer> visited = new HashSet<>();
	boolean isTree = dfs(0, map, visited, null);
	if(!isTree) return false;
    for(int i = 0; i < n; i++){
        if(!visited.contains(i)) return false;
    }
    
	return true;
}

private boolean dfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited, Integer parent){
	if(visited.contains(vertex)) return false;
	visited.add(vertex);
	List<Integer> nei = graph.get(vertex);
	for(int currNei: nei){
		if(parent == null || ((int)parent != currNei)){
			if(visited.contains(currNei)) return false;
			if(!dfs(currNei, graph, visited, Integer.valueOf(vertex))) return false;
		}
	}
	return true;
}