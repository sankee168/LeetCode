//Space complexity: O(k)
//Time complexity: O(n+k)
public void rotate(int[] nums, int k) {
	k  = k%nums.length;
	if(k == 0) return;
	int[] temp = new int[k];
	int j = 0;
	for(int i = nums.length-k; i < nums.length; i++){
		temp[j++] = nums[i];
	}

	j = nums.length-1;
	for(int i = nums.length-k-1; i >=0; i--){
		nums[j--] = nums[i];
	}

	for(int i = 0; i < k; i++){
		nums[i] = temp[i];
	}
}

//this is tricky solution using reversing
//Reverse complete array then reverse first k elements and then reverse remaining elements
//Time complexity: O(n)
//Space complexity: O(1)
public void rotate(int[] nums, int k){
	k = k%nums.length;
	reverse(nums, 0, nums.length-1);
	reverse(nums, 0, k-1);
	reverse(nums, k, nums.length-1);
}

private void reverse(int[] nums, int i, int j){
	while(i < j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		i++; j--;
	}
}

//This is inplace rotation. we are storing prev value in the temp array and keep an eye on the count of rotated integers. 
//Space complexity: O(1)
//Time complexity: O(n)
public void rotate(int[] nums, int k){
	k = k%nums.length;
	if(k == 0) return;
	int count = 0;	
	for(int i = 0; count < nums.length; i++){
		int prevIndex = i;
		int prevValue = nums[i];

		do{
			int curIndex = (prevIndex + k) %nums.length;
			int temp = nums[curIndex];
			nums[curIndex] = prevValue;
			prevValue = temp;
			prevIndex = curIndex;
			count++;
		}while(prevIndex != i);
	}
}