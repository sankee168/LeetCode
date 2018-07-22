//Idea here is to see how we can reach ith step. Say f(i) is the function determining steps required to reach ith step. 
//then f(i) = f(i-1) + f(i-2) because ith step can be reached from i-1th step or i-2 step. 
//Time complexity: O(n)
//Space complexity: O(1)
public int climbStairs(int n) {
	int p1 = 1;
	int p2 = 2;
	if(n == 0) return 0;
	if(n == 1) return 1;
	if(n == 2) return p2;
	for(int i = 3; i <= n; i++){
		int curStep = p1+p2;
		p1 = p2;
		p2 = curStep;
	}
	return p2;
}
