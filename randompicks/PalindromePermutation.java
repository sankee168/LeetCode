//Time complexity: O(n)
//Space complexity: O(n)
public boolean canPermutePalindrome(String s) {
	Map<Character, Integer> map = new HashMap<>();
	for(int i = 0; i < s.length(); i++){
		map.put(s.charAt(i), map.getOrDefault(s.charAt(i))+1);
	}

	int oddCount = 0;
	for(Map.Entry<Character, Integer> curr: map){
		if(curr.getValue()%2 == 1) oddCount++;
	}

	if(oddCount > 1) return false;
	return true;
}


//instead of using map, use int array of 128 because there are 128 ASCII characters that will decrease space complexity to O(1)