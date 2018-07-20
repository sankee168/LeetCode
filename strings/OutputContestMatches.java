//Time complexity: O(nlogn)
//Space complexity: O(nlogn)
 public String findContestMatch(int n) {
	String[] arr = new String[n];
	for(int i = 0; i <n; i++){
		arr[i] = Integer.toString(i+1);
	}
    
    int p = arr.length;
	while(p != 1){		
		int i = 0;
		int j = p-1;
		while(i < j){
            StringBuilder sb = new StringBuilder();
			sb.append("(").append(arr[i]).append(",").append(arr[j]).append(")");
            arr[i] = sb.toString();
			i++;
            j--;
		}
        p = p/2;
	}
	
	return arr[0];
}