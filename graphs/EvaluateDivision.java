//Identifying this problem as graph is bit tough
//but once we identify, we have to find path between two strings of a query
//if there exists a path, then we can evaluate the division
//here are few conditions we have to consider
//check if graph contains source of the query. if not return -1
//check if source's neighbors has destination if so return that value
//if not keep doing dfs
//if no path is found return -1
//keep a check on visited nodes too
//Time complexity: O(E) as we are iteraring through equations once and through all the edges once
//Space complexity: O(E)
public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	Map<String, Map<String, Double>> graph = new HashMap<>();
	for(int i = 0; i < equations.length; i++){
		String s = equations[i][0];
		String d = equations[i][1];
		if(!graph.containsKey(s)){
			graph.put(s, new HashMap<String, Double>());
		}
		if(!graph.containsKey(d)){
			graph.put(d, new HashMap<String, Double>());
		}
        graph.get(s).put(d, values[i]);
		graph.get(d).put(s, 1/((double) values[i]));
	}


	double[] res = new double[queries.length];
	for(int i = 0; i < queries.length; i++){
        Set<String> visited = new HashSet<>();
        visited.add(queries[i][0]);
		res[i] = calculate(queries[i][0], queries[i][1], graph, visited);
	}

	return res;
}

private double calculate(String source, String destination, Map<String, Map<String, Double>> graph, Set<String> visited){
    if(!graph.containsKey(source)) return -1;
	Map<String, Double> nei = graph.get(source);
	if(nei.containsKey(destination)) return nei.get(destination);
	else if(source.equals(destination)) return 1;
	else{
		for(Map.Entry<String, Double> edge: nei.entrySet()){
			if(visited.contains(edge.getKey())) continue;
            visited.add(edge.getKey());
            double curVal = edge.getValue();
			double remValue = calculate(edge.getKey(), destination, graph, visited);
            visited.remove(edge.getKey());
			if(remValue != -1) return curVal*remValue;
		}
	}
	return -1;
}