//This solution is using maxheap. Have maxheap of all the digits
//and start comparing every poll with the digit from beginning, if it is not equal that digit has to swapped with polled element. 
//search for polled element from end of the array and swap. 
//Time complexity: O(nlogn)
//Space complexity: O(n)
private class MaxHeapComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer a, Integer b){
		if(a > b) return 1;
		else if(a == b) return 0;
		return -1;
	}
}
public int maximumSwap(int num) {
	int n = 1;
	int temp = num;
	while(temp/10 != 0){
		n++;
		temp = temp/10;
	}

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, new MaxHeapComparator());

	int[] arr = new int[n];
	temp = num;
	int i = n-1;
	while(temp != 0){
		arr[i] = temp%10;
		maxHeap.offer(arr[i]);
		temp = temp/10;
		i--;
	}

	int swapIndex = 0;
	while(!maxHeap.isEmpty() && maxHeap.peek() == arr[swapIndex]){
		maxHeap.poll();
		swapIndex++;
	}

	for(int j = swapIndex+1; j < n; j++){
		if(arr[j] == maxHeap.peek()){
			arr[j] = arr[swapIndex];
			arr[swapIndex] = maxHeap.poll();
			break;
		}
	}

	temp = 0;
	i = 0;
	while(i < n){
		temp = 10*temp + arr[i];
	}

	return temp;
}

//Time complexity: O(n)
//Space complexity: O(1)
public int maximumSwap(int num){
	char[] arr = Integer.toString(num).toCharArray();
	int[] last = new int[10];
	for(int i = 0; i < arr.length; i++){
		//storing last occurence of that digit
		last[arr[i] - '0'] = i;
	}

	for(int i = 0; i < arr.length; i++){
		//check if there is any number which is greater than ith index
		for(int j = 9; j > arr[i] - '0'; j--){
			//this if block primarly for checking if last occurance of j(which is greater than ithe index) is after ith index
			if(last[j] > i){
				char temp = arr[i];
				arr[i] = arr[last[j]];
				arr[last[j]] = temp;
				return Integer.valueOf(new String(A));
			}
		}
	}

	return num;
}