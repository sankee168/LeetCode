public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	Map<Integer, List<Integer>> map = new HashMap<>();
	for(int i = 0; i < ppid.size(); i++){
		int parent = ppid.get(i);
		int child = pid.get(i);
		if(map.keySet().contains(parent)){
            List<Integer> temp = map.get(parent);
            temp.add(child);
			map.put(parent, temp);
		}else{
			List<Integer> list = new ArrayList<>();
			list.add(child);
			map.put(parent, list);
		}
	}

	List<Integer> temp = map.get(kill);
    if(temp == null){
        temp = new ArrayList<>();
    }else{
	int i = 0;
		while(i != temp.size()){
			int p = temp.get(i);
			if(map.keySet().contains(p)){
				temp.addAll(map.get(p));
			}
			i++;
		}
    }
	temp.add(kill);
	return temp;
}