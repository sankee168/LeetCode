//We do a depth first search here, keep a track of what all nodes we visited while traversal in the visiter array
//when we see the count==totalRooms then we return true else we keep iterating over those keys which are not visited
//Time complexity: O(V+E) we won't traverse the edge once visited
//Space complexity: O(V) for visited array and recursive stack
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	int n = rooms.size();
	int[] visited = new int[n];
	int[] count = {0};
	return dfs(rooms, visited, count, n, 0);
}


private boolean dfs(List<List<Integer>> rooms, int[] visited, int[] count, int totalRooms, int index){
	if(visited[index] == 0){
		visited[index] = 1;
		count[0]++;
	}else return false;
    if(count[0] == totalRooms) return true;
	List<Integer> keys = rooms.get(index);
	for(int key: keys){
		if(dfs(rooms, visited, count, totalRooms, key)) return true;
	}

	return false;
}