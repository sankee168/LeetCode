//We can use topological sort for this. 
//At every layer we add them to returned list in the order
//time complexity: O(m+n)
//space complexity: O(m+n)
public int[] findOrder(int numCourses, int[][] prerequisites) {
	int[] outdegree = new int[numCourses];
	List<Integer>[] graph = new List<>[numCourses];
	for(int i = 0; i < numCourses; i++){
		graph[i] = new ArrayList<>();
	}

	for(int i = 0; i < prerequisites.length; i++){
		int s = prerequisites[i][0];
		int d = prerequisites[i][1];
		graph[d].add(s);
		outdegree[s]++;
	}

	Queue<Integer> queue = new LinkedList<>();
	for(int i = 0; i < numCourses; i++){
		if(outdegree[i] == 0) queue.add(i);
	}

	if(queue.size() == 0) return new int[]{};

	int index = 0;
	int[] order = new int[numCourses];
	while(!queue.isEmpty()){
		int curLeaf = queue.poll();
		order[index++] = curLeaf;
		List<Integer> sources = graph[curLeaf];
		for(int source: sources){
			outdegree[source]--;
			if(outdegree[source] == 0) queue.add(source);
		}
	}
	if(index == numCourses) return order;
	return new int[]{};
}