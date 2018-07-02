//Time complexity: O(m2)
//Space complexity: O(1)
//Time limit exceeded
public int maxDistance(List<List<Integer>> arrays) {
	int max = Integer.MIN_VALUE;
	for(int i = 0; i < arrays.size(); i++){
		for(int j = 0; j < arrays.size(); j++){
			if(i != j){
				List<Integer> arr1 = arrays.get(i);
				List<Integer> arr2 = arrays.get(j);
				int min1 = arr1.get(0);
				int max1 = arr1.get(arr1.size()-1);
				int min2 = arr2.get(0);
				int max2 = arr2.get(arr2.size()-1);

				int tempMax = Math.max(Math.abs(max2-min1), Math.abs(max1-min2));
				max = Math.max(tempMax, max);
			}
		}
	}
	return max;
}

//Time complexity: O(n)
//Space complexity: O(1)
public int maxDistance(List<List<Integer>> arrays) {
	int minValue = arrays.get(0).get(0);
	int maxValue = arrays.get(0).get(arrays.get(0).size()-1);
	int result = 0;
	for(int i = 1; i < arrays.size(); i++){
		List curr = arrays.get(i);
		int temp1 = Math.abs(curr.get(curr.size()-1) - minValue);
		int temp2 = Math.abs(maxValue - curr.get(0));
		result = Math.max(result, Math.max(temp1, temp2));
		minValue = Math.min(minValue, curr.get(0));
		maxValue = Math.max(maxValue, curr.get(curr.size()-1));
	}
	return result;
}