//Simple question with lot of description. 
//Time complexity: O(n)
//Space complexity: O(1)
//We just have to make sure if two time series are overlapped, if so add difference in start time else add duration
public int findPoisonedDuration(int[] timeSeries, int duration) {
	if(timeSeries.length == 0) return 0;
	int totalTime = 0;
	for(int i = 0; i < timeSeries.length-1; i++){
		int curr = timeSeries[i];
		int next = timeSeries[i+1];
		if(next < curr+ duration){
			totalTime += next-curr;
		}else totalTime += duration;
	}

	totalTime += duration;
	return totalTime; 
}