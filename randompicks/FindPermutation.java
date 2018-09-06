//Given constraints are
//1. sequence should be lexicographically smallest
//2. All of them are unique
//Keeping this in mind, we will be using n first integers for generating the sequence
//whenever we see D to I trantition, we reverse all the Ds
//Time complexity: O(n)
//Space complexity: O(n) for result array
public int[] findPermutation(String s) {
	int n = s.length()+1;
    if(n == 1) return new int[]{};
	int[] res = new int[n];
	for(int i = 0; i < n; i++){
		res[i] = i+1;
	}

    int i = 0;
	while(i < n-1){
		if(s.charAt(i) == 'D'){
			int j = i;
			while(j < n-1 && s.charAt(j) == 'D') j++;
			reverse(res, i, j);
			i = j-1;
		}
		i++;
	}

	return res;
}

private void reverse(int[] res, int i, int j){
	while(i < j){
		int temp = res[i];
		res[i] = res[j];
		res[j] = temp;
		i++;j--;
	}
}