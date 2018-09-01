//Idea here is to detect cycle or do a topological sort of cources based on prereqs
//This solution is bfs approach
public boolean canFinish(int numCourses, int[][] prerequisites) {
	Map<Integer, List<Integer>> map =  new HashMap<>();
	for(int i = 0; i < numCourses; i++){
		map.put(i, new ArrayList<Integer>());
	}
	for(int i = 0; i < prerequisites.length; i++){
		map.get(prerequisites[i][0]).add(prerequisites[i][1]);
	}
	int count = 0;
	Queue<Integer> queue = new LinkedList<>();
	for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
		if(entry.getValue().size() == 0){
			count++;
			queue.add(entry.getKey());
		}
	}
	if(queue.size() == 0) return false;

	while(!queue.isEmpty()){
		int leaf = queue.poll();
		for(int i = 0; i < numCourses; i++){
			if(map.get(i).contains(leaf)){
				map.get(i).remove(Integer.valueOf(leaf));
				if(map.get(i).size() == 0){
					queue.add(i);
					count++;
				}
			}
		}
	}

	return count == numCourses;
}

public boolean canFinish(int numCourses, int[][] prerequisites) {
	int[] degree = new int[numCourses];
	ArrayList[] graph = new ArrayList[numCourses];
	Queue<Integer> queue = new LinkedList<>();
	int count = 0;
	for(int i = 0; i < numCourses; i++){
		graph[i] = new ArrayList<Integer>();
	}

	for(int i = 0; i < prerequisites.length; i++){
		degree[prerequisites[i][0]]++;
		graph[prerequisites[i][1]].add(prerequisites[i][0]);
	}

	for(int i = 0; i < numCourses; i++){
		if(degree[i] == 0) {
            queue.add(i);
		    count++;   
        }
	}

	while(!queue.isEmpty()){
		int leaf = queue.poll();
		for(int i = 0; i < graph[leaf].size(); i++){
			int dep = (int)graph[leaf].get(i);
			degree[dep]--;
			if(degree[dep] == 0) {
				count++;
				queue.add(dep);
			}
		}
	}

	return count == numCourses;
}


//this solution is dfs approach
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