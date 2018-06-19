//This problem is mainly about finding the largest element's index in an array. 
//Time Complexity : O(n) Space complexity: O(1)
public int peakIndexInMountainArray(int[] A){
	int max = Integer.MIN_VALUE;
	int index = 0;
	for(int i = 0; i < A.length; i++){
		if(A[i] > max){
			index = i;
			max = A[i];
		}
	}

	return index;
}


//We can optimize this using binary search which should get time complexity to O(logn)
public int peakIndexInMountainArray(int[] A){
	int i = 0; int j = A.length;
	return binarysearch(A, i, j);
}

private int binarysearch(int[] A, int i, int j){
	int mid = (i+j)/2;
	if(A[mid] > A[mid+1] && A[mid] > A[mid-1]) return mid;
	else if(A[mid] > A[mid+1] && A[mid-1] > A[mid]) return binarysearch(A, i, mid);
	return binarysearch(A, mid, j);
}