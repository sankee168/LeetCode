//we have to observe two facts here
//1. if A cannot reach C, B also cannot reach C(think mathematically)
//2. if sum of all costs is less than 0 then there is no possible way
//Time complexity: O(n)
//Space complexity: O(1)
public int canCompleteCircuit(int[] gas, int[] cost) {
	int n = gas.length;
	int totalSum = 0;
	int curSum = 0;
	int index = 0;
	for(int i = 0; i < n; i++){
		int curCost = gas[i]-cost[i];
		if(curSum >= 0){
			curSum += curCost;
		}else{
			index = i;
			curSum = curCost;
		}
		totalSum += curCost;
	}

	if(totalSum >= 0) return index;
	return -1;
}