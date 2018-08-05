//Time complexity: O(nlogn) for sorting
//Space complexity: O(1)
public int numRescueBoats(int[] people, int limit) {
	Arrays.sort(people);
	int count = 0;
	int i = 0, j = people.length-1;
	while(i <= j){
		int sum = people[i]+people[j];
		if(sum > limit) j--;
		else {
			i++; j--;
		}
		count++;
	}

	return count;
}