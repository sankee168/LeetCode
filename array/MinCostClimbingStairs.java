//To be at nth stair, one can come from n-1th stair or n-2 stair. 
//so cost occured to reach nth start will the min of cost occured 
//to reach n-1th stair and n-2 stair plus cost of nth stair
//Time complexity: O(n)
//Space compelxity: O(1)
public int minCostClimbingStairs(int[] cost) {
	int f2 = cost[0];
	int f1 = cost[1];
	for(int i = 2; i < cost.length; i++){
		int f0 = Math.min(f1, f2) + cost[i];
		f2 = f1;
		f1 = f0;
	}
	return Math.min(f1, f2);
}