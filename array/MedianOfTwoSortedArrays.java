 //No clue how this idea came up. 
//look at this post https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
//Time complexity: O(log(m+n))
//Space complexity: O(1)

//First step : As we have two sorted arrays, we should determine where we should cut these two arrays into two parts each such left count and right count sum is equal
//Second step: For any array, elements on the both sides of the middle cut are n-1/2 and n/2 indices where n is the length of the array no matter if it is odd or even
//Third step: Determining where to cut. we generally try to cut smaller array first so that we can easily determine where we should cur in bigger array. To start with we will cur 
//Fourth step: we compare elements on either side of both the cuts to determibne which half is bigger or smaller so that we can move out cut in that direction
//say l1,r1 are elements on either side of first array and similarly second
//if l1 > r2 that means first array left half elements are larger which means we have to move that cut to left, which means we have move cut2 to the right
//and we calculated second 2 as (lo+hi)/2 so we increase lo to mid2+1
 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int n1 = nums1.length;
	int n2 = nums2.length;
	if(n2 > n1) return findMedianSortedArrays(nums2, nums1);
	int lo = 0;
	int hi = n2*2;
	while(lo <= hi){
		int mid2 = (lo+hi)/2;
		int mid1 = n1+n2-mid2;
		int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];
		int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
		int r1 = (mid1 == 2*n1) ? Integer.MAX_VALUE : nums1[mid1/2];
		int r2 = (mid2 == 2*n2) ? Integer.MAX_VALUE : nums2[mid2/2];

		if(l1 > r2){
			lo = mid2 +1;
		}else if(l2  > r1){
			hi = mid2 -1;
		}else{ 
            return (Math.max(l1, l2) + Math.min(r1, r2))/(double)2;
        }
    }
	return -1;
}