//Idea is to keep map with key as content of the file and value as the list of files with that content
//Time complexity: n*k where n is the length of the paths array and k is the average size of the strings
//Space complexity: n*k 
public List<List<String>> findDuplicate(String[] paths) {
	Map<String, List<String>> map = new HashMap<>();
	List<List<String>> list = new ArrayList<>();
	for(String curr: paths){
		String[] arr = curr.split(" ");
		String root = arr[0];		
		for(int i = 1; i < arr.length; i++){
			StringBuilder sb = new StringBuilder();
			sb.append(arr[0]);
			int index = arr[i].indexOf('(');
			sb.append("/").append(arr[i].substring(0, index));
			String content = arr[i].substring(index+1, arr[i].length()-1);
            if(map.containsKey(content)){
                map.get(content).add(sb.toString());
            }else {
                List<String> val = new ArrayList<>();
                val.add(sb.toString());
                map.put(content, val);
            }
		}
	}

	for(Map.Entry<String, List<String>> curr: map.entrySet()){
		if(curr.getValue().size() > 1){
			list.add(curr.getValue());
		}
	}

	return list;
}