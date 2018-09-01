//The idea here is to cut down leaves every iteration
//we create a graph in the first place
//we check if degree of any vertex is one as input is undirected graph which is a leaf node
//then every iteration we remove leaf nodes. so at the end there will be either 1 or 2. 
//In every iteration we have to remove links to previous leaves and identify next set of leaf vertices
//Time complexity: O(V+E)
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       if(n == 0) return new ArrayList<Integer>();
       List<Integer> leaves = new ArrayList<>();
       if(n == 1){
           leaves.add(0);
           return leaves;
       }
       Map<Integer, List<Integer>> map = new HashMap<>();
       for(int i = 0; i < n; i++){
           map.put(i, new ArrayList<Integer>());
       }
       for(int i = 0; i < edges.length; i++){
           map.get(edges[i][0]).add(edges[i][1]);
           map.get(edges[i][1]).add(edges[i][0]);
       }
       
       for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
           if(entry.getValue().size() == 1) leaves.add(entry.getKey());
       }
       while(n > 2){
           List<Integer> newLeaves = new ArrayList<>();
           n -= leaves.size();
           for(int j = 0; j < leaves.size(); j++){
               int leaf = leaves.get(j);
               List<Integer> nei = map.get(leaf);
               for(int i = 0; i < nei.size(); i++){
                   int toRemove = nei.get(i);
                   map.get(toRemove).remove(Integer.valueOf(leaf));
                   if(map.get(toRemove).size() == 1){
                       newLeaves.add(toRemove);
                   }
               }
           }
           leaves = newLeaves;
       }
       return leaves;
   }


//we can use dfs approach to solve this too
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
  Map<Integer, List<Integer>> map = new HashMap<>();
  for(int i = 0; i < n; i++){
map.put(i, new ArrayList<Integer>());
}
for(int i = 0; i < edges.length; i++){
  map.get(edges[i][0]).add(edges[i][1]);
  map.get(edges[i][1]).add(edges[i][0]);
}

  int minDepth = Integer.MAX_VALUE;
  List<Integer> list = new ArrayList<>();
  for(int i = 0; i < n; i++){
    Set<Integer> visited = new HashSet<>();
    visited.add(i);
  int depth = dfs(i, map, visited, 0);
  if(depth == minDepth) list.add(i);
  else if(depth < minDepth) {
    depth = minDepth;
    list = new ArrayList<>();
    list.add(i);
}
}
}

private int dfs(int vertex, Map<Integer, List<Integer>> map, Set<Integer> visited, int depth){
  int maxDepth = depth;
  List<Integer> nei = new ArrayList<>();
  for(int currNei : nei){
  if(!visited.contains(currNei)){
    visited.add(currNei);
  int tempDepth = dfs(currNei, map, visited, depth+1);
  maxDepth = Math.max(maxDepth, tempDepth);
  visited.remove(currNei);
}
}
return maxDepth;
}
