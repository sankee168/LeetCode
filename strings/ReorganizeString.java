//Idea is to get the most occuring character and place it next to prev. There will be cases where one char is over numbered
//So better to take two chars and see if first char doesn't match the previous char, then append else other one 
//Push back them after updating the count
//Time complexity: O(nlogn) where n is the length of S
//Space compelxity: O(n)
int[] arr = new int[26];
public String reorganizeString(String S) {
	for(int i = 0; i < S.length(); i++){
		arr[S.charAt(i)-'a']++;
	}

	char[] res = new char[S.length()];
	int index = 0;
	PriorityQueue<Character> pq = new PriorityQueue(new FreqComparator());
	for(int i = 0; i < 26; i++){
		if(arr[i] != 0) pq.offer((char)(i+'a'));
	}

	while(index < S.length() && !pq.isEmpty()){
		char maxFrequencyChar = pq.poll();
		if(index == 0 || (maxFrequencyChar != res[index-1])){
			res[index] = maxFrequencyChar;
			arr[maxFrequencyChar-'a']--;
			if(arr[maxFrequencyChar-'a'] != 0) pq.offer(maxFrequencyChar);
		}else{
			if(maxFrequencyChar == res[index-1]){
				if(pq.size() > 0){
					char secondMaxFrequncyChar = pq.poll();
					res[index] = secondMaxFrequncyChar;
					arr[secondMaxFrequncyChar-'a']--;
					if(arr[secondMaxFrequncyChar-'a'] != 0) pq.offer(secondMaxFrequncyChar);
				}else return "";
			    pq.offer(maxFrequencyChar);
            }
		}
		index++;
	}
	return String.valueOf(res);

}

private class FreqComparator implements Comparator<Character> {
	public int compare(Character a, Character b){
		return (arr[b-'a']-arr[a-'a']);
	}
}