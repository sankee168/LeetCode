//this is dfs implementation. we need to check if there exists a cycle in the graph
//we have to check for in all the nodes for cycles
public boolean canFinish(int numCourses, int[][] prerequisites) {
	Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < numCourses; i++){
        map.put(i, new ArrayList<Integer>());
    }
    for(int i = 0; i < prerequisites.length; i++){
        int source = prerequisites[i][0];
        map.get(source).add(prerequisites[i][1]);
    }
    Set<Integer> visited = new HashSet<>();
    for(int i = 0; i < numCourses; i++){
        if(!dfs(i, visited, map)) return false;
    }
    return true;
}

private boolean dfs(int vertex, Set<Integer> set, Map<Integer, List<Integer>> map){	
    if(set.contains(vertex)) return false;
	set.add(vertex);
	List<Integer> list = map.get(vertex);
	for(int i = 0; i < list.size(); i++){
		if(!dfs(list.get(i), set, map)) return false;
	}
    set.remove(vertex);
	return true;
}