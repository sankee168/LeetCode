//two pass solution. first pass to get the count of each color
//next pass to set them in the array
public void sortColors(int[] nums) {
    int red = 0, white = 0, blue = 0;
    for(int curr: nums){
        if(curr == 0) red++;
        else if(curr == 1) white++;
        else if(curr == 2) blue++;
    }        
    int i = 0;
    while(red > 0 || white > 0 || blue > 0){
        if(red > 0){
            nums[i++] = 0; red--;
        }else if(white > 0){
            nums[i++] = 1; white--;
        }else {
            nums[i++] = 2; blue--;
        }
    }
    return;
}

//we will try to do this in one pass
//we have two pointers for start and end
//if the current value is 0 that should go to the front index value
//if the current value is 2 that should go to the last index value
void sortColors(int A[]) {
    int j = 0, k = A.length-1;
    for (int i=0; i <= k; i++) {
        if (A[i] == 0){
            // swap(A[i], A[j++]);
            int temp = A[i];
            A[i] = A[j];
            A[j++] = temp;
        }
        else if (A[i] == 2){
            //swap(A[i--], A[k--])
            int temp = A[i];
            A[i] = A[k];
            A[k] = temp;
            i--; k--;
        }
    }
}