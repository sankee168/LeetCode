//We will do a bfs to color each node. 
//Time complexity: O(V+E)
//Space complexity: O(V)
public boolean isBipartite(int[][] graph) {
	int n = graph.length;
	int[] colors = new int[n];
	return bfs(graph, colors);
}

private boolean bfs(int[][] graph, int[] colors){
	Queue<Integer> queue = new LinkedList<>();
	for(int i = 0; i < graph.length; i++){
		if(colors[i] == 0) queue.add(i);
		while(!queue.isEmpty()){
			int curVertex = queue.poll();
			if(colors[curVertex] == 0){
				colors[curVertex] = 1;				
			}
			int[] nei = graph[curVertex];
			for(int j= 0; j < nei.length; j++){
				if(colors[nei[j]] == colors[curVertex]) return false;
				if(colors[nei[j]] == 0){
					if(colors[curVertex] == 1) colors[nei[j]] = 2;
					else colors[nei[j]] = 1;
					queue.add(nei[j]);
				}
			}
		}
	}
    return true;
}