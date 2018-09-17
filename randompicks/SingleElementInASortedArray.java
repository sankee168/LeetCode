//as we are given only one element doens't have duplicate, our problem is to find that even index where it's value is 
//not equal to next index value
//So we always try to keep the mid value in the even index and check
//if it is not equal to next value. that means element lies in left half
//else irght half
//Time complexity: O(logn)
//Space complexity; O(1)
public int singleNonDuplicate(int[] nums) {
    int i = 0, j = nums.length-1;
    while(i<j){
        int mid = (i+j)/2;
        if(mid%2 == 1){
            mid = mid-1;
        }
        if(nums[mid] != nums[mid+1]){
            j = mid;
        }else{
            i = mid+2;
        }
    }
    return nums[i];
}