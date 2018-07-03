//Time complexity O(nk)
//Space complexity O(1)
public int[] getModifiedArray(int length, int[][] updates) {
	int[] ans = new int[length];
	for(int i = 0; i < length; i++){
		int val = 0;
		for(int j = 0; j < updates.length; j++){
			if(i >= updates[j][0] && i <= updates[j][1]){
				val += updates[j][2];
			}
		}
		ans[i] = val;
	}
	return ans;
}

//Simple idea for every update just update the start index with val and end+1 index with -val. 
//At the end cumilative sum will update with right sum
//Time complexity: O(n+k) where n is length and k is updates.length;
//Space complexity: O(1)
public int[] getModifiedArray(int length, int[][] updates){
	int[] ans = new int[length];
	for(int i = 0; i < updates.length; i++){
		ans[updates[i][0]] += updates[i][2];
		if(updates[i][1]+1 < length){
			ans[updates[i][1]+1] -= updates[i][2];
		}
	}

	for(int i = 1; i < length; i++){
		ans[i] = ans[i-1]+ans[i];
	}

	return ans;
}