//Solution here is to use maxheap to get which element to pick next. 
//Ideally highest occurance element is picked and then next highest and so on
//But we have to keep in mind that we have keep executing other tasks till idle timeout of most occuring element(first one) expires. 
//Time complexity: O(n)
//Space complexity: O(1) as we are using constant space for array and maxHeap
public int leastInterval(char[] tasks, int n) {
	int count = 0;
	int[] map = new int[26];
	for(char i: tasks){
		map[i - 'A']++;
	}

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());
	for(int i : map){
		if(i > 0) maxHeap.offer(i);
	}

	while(!maxHeap.isEmpty()){
		int timer = 0;
		List<Integer> temp = new ArrayList<>();
		while(timer <= n){
			if(!maxHeap.isEmpty()){	
				if(maxHeap.peek() > 1){
					temp.add(maxHeap.poll() -1);
				}else maxHeap.poll();
			}
            count++;
            if(maxHeap.isEmpty() && temp.size() == 0) break;
			timer++;			
		}

		for(int i: temp){
			maxHeap.offer(i);
		}
	}
	return count;
}


//This is tricky solution. picturize this and it will be easy. 
//calculate the idle slots 
//Time complexity: O(n)
//Space compelxity: O(1)
public int leastInterval(char[] tasks, int n) {
	int[] map = new int[26];
	for(char i: tasks){
		map[i - 'A']++;
	}
	Arrays.sort(map);
	int max = map[25];
	int idleslots = (max-1)*n;
	for(int i = 0; i < 25; i++){
		idleslots -= Math.min(map[i], max-1);
	}
	if(idleslots > 0) return tasks.length + idleslots;
	return tasks.length;
}