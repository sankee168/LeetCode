//Simple for loop with a check on previous character
//If cur char macthes keep udpating end index
//when breaks check if group has atleast 3 elements. 
//If so add start and end to temp list and add to return list.
//Time complexity: O(n)
//Space complexity: O(n) returned list
public List<List<Integer>> largeGroupPositions(String S) {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> curr = new ArrayList<>();
	int start = 0;
	int end = 0;
	for(int i = 1; i < S.length(); i++){
		if(S.charAt(i) == S.charAt(i-1)){
			end++;
		}else{
			if(end-start+1 >= 3){
				curr.add(start); curr.add(end);
				ans.add(curr);
				curr = new ArrayList<>();				
			}
			start = i; end = i;
		}
	}

	if(end == S.length()-1 && end-start+1 >=3){
		curr.add(start); curr.add(end-1);
		ans.add(curr);
	}
	return ans;
}