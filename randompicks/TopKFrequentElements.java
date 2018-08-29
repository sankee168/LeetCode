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