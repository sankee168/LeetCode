//Lets say you are half way through, next number is nothing but minimum product of a number in the set with 2,3,5
//If we observe closely, every number has its factor with 2,3 and 5. So we keep indices for next number to be multiplied with 2,3 and 5
//At the same time, we maintain what those numbers are. In every iteration we just have to find the minimum of those and increment the 
//indices if product is equal to that number
//Time complexity: O(n)
//Space complexity: O(n)
public int nthUglyNumber(int n) {
    int[] arr = new int[n];
    arr[0] = 1;
    int i2 = 0,i3 = 0, i5 = 0;
    int factor2 = 2,factor3=3,factor5=5;
    for(int i = 1; i <n; i++){
        int min = Math.min(Math.min(factor2, factor3), factor5);
        arr[i] = min;
        if(factor2 == min){
            i2++;
            factor2 = 2*arr[i2];
        }
        if(factor3 == min){
            i3++;
            factor3 = 3*arr[i3];
        }
        if(factor5 == min){
            i5++;
            factor5 = 5*arr[i5];
        }
    }
    return arr[n-1];
}