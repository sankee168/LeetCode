//we have to check if given number is sum of squares of two numbers
public boolean judgeSquareSum(int c) {
	for(long a = 0; a*a <= c; a++){
		for(long b = 0; b*b <= c; b++){
			if(a*a + b*b == c) return true;
			if(a*a + b*b > c) break;
		}
	}
	return false;
}


public boolean judgeSquareSum(int c){
	for(long a = 0; a*a <=c; a++){
		double b = Math.sqrt(c- a*a);
		if(b == (int) b) return true;
	}
	return false;
}