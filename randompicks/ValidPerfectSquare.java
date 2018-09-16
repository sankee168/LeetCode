public boolean isPerfectSquare(int num) {
        for(int i = 0; i*i <= num; i++){
            if(i*i == num) return true;
        }
        return false;
    }

//rather than doing sequentially, we can do binary seach from 0 to num
//we just use long just to make sure we are not overloading numbers
public boolean isPerfectSquare(int num){
	long low = 1, high = num;
	while(low <= high){
		long mid = (low+high)/2;
		if(mid*mid == num)return true;
		if(mid*mid < num){
			low = mid+1;
		}
		else high = mid-1;
	}
	return false;
}

//Interesting fact about perfect square is it is sum of all the off numbers
//1+3+5+7+9

public boolean isPerfectSquare(int num){
	for(int i = 1; num > 0; i += 2){
		num -= i;
	}

	if(num == 0) return true;
	return false;
}