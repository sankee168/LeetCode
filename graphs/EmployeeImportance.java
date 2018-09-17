//bfs approach
public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for(Employee curr: employees){
        map.put(curr.id, curr);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(id);
    int importance = 0;
    while(!queue.isEmpty()){
        Employee currEmployee = map.get(queue.poll());
        importance += currEmployee.importance;
        for(int sub : currEmployee.subordinates){
            queue.add(sub);
        }
    }
    return importance;
}

//dfs approach
public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for(Employee curr: employees){
        map.put(curr.id, curr);
    }
    return dfs(map, id);
}

private int dfs(Map<Integer, Employee> map, int id){
    Employee curr = map.get(id);
    int imp = curr.importance;
    for(int sub : curr.subordinates){
        imp += dfs(map, sub);
    }
    return imp;
}
