//how do we find the square root. general approach is to go till x/2
//and check if maximum number less than x which is O(n)
//but we can do binary search
public int mySqrt(int x){
	int i = 1, j = x;
	int ans = 0;
	while(i <= j){
		int mid = (i+j)/2;
		if(mid == x/mid) return mid;
		if(mid < x/mid) {
			ans = mid;
			i = mid+1;
		}else{
			j = mid-1;
		}
	}
	return ans;
}

//brute force. O(n)
public int mySqrt(int x){
        if(x == 0 || x == 1) return x;
        int ans = 0;
        for(int i = 1; i <= x/2; i++){
            if(i == x/i) return i;
            if(i < x/i) ans = i;
            else break;
        }
        return ans;
}