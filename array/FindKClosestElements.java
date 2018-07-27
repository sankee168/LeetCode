public List<Integer> findClosestElements(int[] arr, int k, int x) {
	int c = findCrossOverPoint(arr, x, 0, arr.length-1);
}

private int findCrossOverPoint(int[] arr, int x, int start, int end){
	if(arr[end] <= x) return end;
	if(arr[start] > x) return start;
	int mid = (start+end)/2;
	if(arr[mid] <= x && arr[mid+1] > x){
		return mid;
	}else if(arr[mid] < x){
		start = mid+1;
	}else end = mid-1;
	return findCrossOverPoint(arr, x, start, end);
}