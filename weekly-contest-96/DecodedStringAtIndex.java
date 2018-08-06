//This solution works by building the decoded string completely. 
//Memory limit exceeded
public String decodeAtIndex(String S, int K) {
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < S.length(); i++){
		char curr = S.charAt(i);
		if(curr >= '2' && curr <= '9'){
			String tmp = sb.toString();
			int reps = curr-'0';
			while(reps > 1){
				sb.append(tmp);
                reps--;
			}
		}else {
			sb.append(curr);
		}
	}

	return sb.toString().substring(K-1, K);
}


