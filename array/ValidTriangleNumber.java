//Condition for any three elements of array to form a triange
//say a, b, c are claimed sides of triangles
//a + b > c; b+c > a; a+c > b

//brute force
//Time complexity: O(n3)
public int triangleNumber(int[] nums){
	int count = 0;
	for(int i = 0; i < nums.length-2; i++){
		for(int j = i+1; j < nums.length-1; j++){
			for(int k = j+1; k < nums.length; k++){
				if(nums[i]+nums[j] > nums[k] && nums[j]+nums[k] > nums[i] && nums[i]+nums[k] > nums[j]) count++;
			}
		}
	}
	return count;
}


//If the numbers are sorted, which means a, b, c are sorted
//out of all three checks, we just have to do one check
//where a + b > c because as c > a & c > b implies c+b > a & c+a > b
//say we fix max length side. then have two pointers i from beginning and j from end
//if that satisfies then all the numbers in between also satisfy
//so count will be (j-i)
//else increase the begin index
//Time complexity: O(n2)
//Space complexity: O(1) for sorting
public int triangleNumber(int[] nums) {
	int count = 0;
	Arrays.sort(nums);
	for(int k = nums.length-1; k >= 2; k--){
		int i = 0, j = k-1;
		while(i < j){
			if(nums[i] + nums[j] > nums[k]){
				count += (j-i);
				j--;
			}else{
				i++;
			}
		}
	}
	return count;
}


//Time complexity: O(n2+logn)
//Space complexity: O(logn) for sorting
public int triangleNumber(int[] nums){
	int count = 0; Arrays.sort(nums);
	for(int i = 0; i < nums.length-2; i++){
		for(int j = i+1; j < nums.length-1; j++){
			int k = binarySearch(nums, i, j);
			count += k-j-1;
		}
	}

	return count;
}

private int binarySearch(int[] nums, int i, int j){
	int p = j+1, q = nums.length-1;
	while(p <= q){
		int mid = (p+q)/2;
		if(nums[mid] >= nums[i] + nums[j]){
			q = mid-1;
		}else p = mid+1;
	}

	return p;
}