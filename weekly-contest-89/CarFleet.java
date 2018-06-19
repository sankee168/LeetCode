//Idea here is to create a map with position and time taken for that car to reach target
// and then use math on values to calculate the number of fleets
public int carFleet(int target, int[] position, int[] speed) {
	if(position.length == 0) return 0;
	Map<Integer, Double> map = new HashMap<>();
	for(int i = 0; i < position.length; i++){
		int currDistance = target-position[i];
		double currTime = currDistance/(double) speed[i];
		map.put(position[i], currTime);
	}

	Arrays.sort(position);
	double cur = 0;
	int count = 0;
	for(int i = position.length-1; i >= 0; i--){
        if(map.get(position[i]) > cur){
            count++;
            cur = map.get(position[i]);
        }
	}
	return count;
}