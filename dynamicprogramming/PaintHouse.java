//Reuse the costs input array to store the sum of the costs. 
//lets say we are painting ith house with blue color, that means i+1th house should be of red or green color. 
//Same logic flows in cost estimating too. start from the first house, as we are not sure which house to paint, we have to consider all the possibilites
//so costs to paint ith house will be cost of the color for ith house + min(cost till i-1th house for other two colors)
//Time complexity: O(n)
//Space complexity: O(1) as we are reusing the same array. 
public int minCost(int[][] cost) {
	if(cost.length == 0) return 0;
	for(int i = 1; i < cost.length; i++){
		cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
		cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
		cost[i][2] += Math.min(cost[i-1][1], cost[i-1][0]);
	}
	return Math.min(cost[cost.length-1][0], Math.min(cost[cost.length-1][1], cost[cost.length-1][2]));
}


//As the idea here is to choose which color to paint for ith house
//lets say if we are painting ith house with red, then i-1th house
//should be painted with blue or green
//similarly for green or blue
public int minCost(int[][] cost){
	int n = cost.length;
	if(n == 0) return 0;
	int lastR = cost[0][0];
	int lastB = cost[0][1];
	int lastG = cost[0][2];
	for(int i = 1; i < n; i++){
		int curR = cost[i][0] + Math.min(lastB, lastG);
		int curB = cost[i][1] + Math.min(lastR, lastG);
		int curG = cost[i][2] + Math.min(lastB, lastR);
		lastR = curR;
		lastG = curG;
		lastB = curB;
	}
	return Math.min(Math.min(lastR, lastG),lastB);
}