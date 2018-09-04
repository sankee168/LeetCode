//This is a sling window problem we have to keep moving left index such that we have only one zero in the window
//Time complexity: O(n)
//Space complexity: O(1)
public int findMaxConsecutiveOnes(int[] nums) {
	int l = 0, h = 0;
	int countOfZeros = 0;
	int max = 0;
	while(h < nums.length){
		if(nums[h] == 0) countOfZeros++;
		while(countOfZeros > 1){
			if(nums[l] == 0){
				countOfZeros--;
			}
			l++;
		}

		max = Math.max(max, h-l+1);
		h++;
	}
	return max;
}

//followup question is when it is steam of numbers
//if we look in the above solution, we are moving l to next zero
//so while we are reading the array, if it is 0 we push into queue so that we know the indices of 0
//when we see that queue size is greater than 0 then we poll the queue and move low pointer of 
//sliding window to that number+1

public int findMaxConsecutiveOnes(int[] nums){
	Queue<Integer> queue = new LinkedList<>();
	int l = 0, h = 0;
	int max = 0;
	while(h < nums.length){
		if(nums[h] == 0) queue.add(h);
		while(queue.size() > 1){
			l = queue.poll()+1;
		}
		max = Math.max(max, h-l+1);
		h++;
	}
	return max;
}