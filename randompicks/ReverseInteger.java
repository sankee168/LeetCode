//As it is given that environment is restricted to hold max size of 32 bits
//we check if next number is going to overflow by this
public int reverse(int x) {
	int res = 0;
	while(x != 0){
		int pop = x%10;
		x = x/10;
		if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) return 0;
		if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8)) return 0;
		res = 10*res + pop;
	}
	return res;
}