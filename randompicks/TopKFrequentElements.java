//This solution is using map to get the frequency of integer
//and use priotrity queue for sorting the integers based on the frequency
//Time complexity: O(nlogn) worst case we have to insert all the elements
//Space complexity: O(n)
Map<Integer, Integer> map = new HashMap<>();
    
public List<Integer> topKFrequent(int[] nums, int k){
	for(int curr: nums){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}
	PriorityQueue<Integer> pq = new PriorityQueue<>(new FrequencyComparator());
	for(int curr: map.keySet()){
		pq.add(curr);
	}

	List<Integer> list = new ArrayList<>();
	while(!pq.isEmpty() && k > 0){
		list.add(pq.poll());
        k--;
	}
	return list;

}

class FrequencyComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b){
		return map.get(b) - map.get(a);
	}
}

//This is implemented using TreeMap where key is the frequency. first we create the usual map and then 
//insert all the elements with that frequency to the treemap
//Time complexity: O(n + klogk) where k is the number of unique elements in the nums and n is the number of
//elements in nums
public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int curr: nums){
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(!treeMap.containsKey(entry.getValue())){
                treeMap.put(entry.getValue(), new ArrayList<Integer>());
            }
            treeMap.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> list = new ArrayList<>();
        while(list.size() < k){
            list.addAll(treeMap.pollLastEntry().getValue());
        }
        return list;
    }


//instead of storing in treemap, if we store in array of Lists of that size. 
//so each index represents frequency and value will have list of words with that frequency 
//Here rather than using priority queue. we used bucket sort which is O(n)
public List<Integer> topKFrequent(int[] nums, int k){
	Map<Integer, Integer> map = new HashMap<>();
	for(int curr: nums){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}

	List<Integer>[] temp = new List[nums.length + 1];
	for(Map.Entry<Integer, Integer> entry: map.entrySet()){
		int val = entry.getValue();
		int key = entry.getKey();
		if(temp[val] == null){
			temp[val] = new ArrayList<Integer>();
		}

		temp[val].add(key);
	}

	List<Integer> list = new ArrayList<>();
	for(int i = temp.length-1; i >=0 && k > 0; i--){
		if(temp[i] != null){
			list.addAll(temp[i]);
			k-=temp[i].size();
		}
	}
	return list;

}