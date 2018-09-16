//Here we use two sets.
//first set to put all the numbers from one array
//second set to put all the numbers from second array which are in previous et
//we iterate over the second set and create a result array
//Time complexity: O(m+n)
//Space complexity: O(m+n) worst case
public int[] intersection(int[] nums1, int[] nums2) {
	 Set<Integer> set = new HashSet<>();
	 if(nums1.length > nums2.length){
	 	return intersection(nums2, nums1);
	 }
	 for(int curr: nums1){
	 	set.add(curr);
	 }

	 Set<Integer> res = new HashSet<>();
	 for(int curr: nums2){
	 	if(set.contains(curr)){
	 		res.add(curr);
	 	}
	 }

	 int[] result = new int[res.size()];
	 int i = 0;
	 Iterator<Integer> iter = res.iterator();
	 while(iter.hasNext()){
	 	result[i++] = iter.next();
	 }
	 return result;
}

//We can sort both the arrays and go each one by one
//Time complexity: O(nlogn + mlogm)
//THis is better used when data set it too large to fit in memory
public int[] intersection(int[] nums1, int[] nums2) {
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	int m = nums1.length;
	int n = nums2.lengthl
	Set<Integer> res = new HashSet<>();
	int i = 0, j = 0;
	while(i < m && j < n){
		if(nums1[i] < nums2[j]) i++;
		else if(nums1[i] > nums2[j]) j++;
		else{
			set.add(nums1[i]);
			i++; j++;
		}
	}

	 int[] result = new int[res.size()];
	 i = 0;
	 for(int curr: res){
	 	result[i++] = curr;
	 }
	 return result;
}