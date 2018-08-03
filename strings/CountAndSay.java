//Time complexity: O(n*k) where k is the average length of res array which again increases with n. So we can say it is O(n2)
//Space complexity: O(n) for res array 
public String countAndSay(int n){
	if(n == 0) return "";
	String res = "1";
	for(int i = 1; i < n; i++){
		StringBuilder sb = new StringBuilder();
		char prev = res.charAt(0);
		int count = 1;
		for(int j = 1; j < res.length(); j++){
			if(res.charAt(j) != prev){
				sb.append(count).append(prev);
				prev = res.charAt(j); count = 1;
			}else count++;
		}
		sb.append(count).append(prev);
		res = sb.toString();
	}
	return res;
}