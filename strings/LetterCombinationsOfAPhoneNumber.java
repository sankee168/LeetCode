//This is typical combination problem. we iterate over the characters of the one digit and in each iteration we check on next digits
//Time complexity: 4^n where n is the length of the digits
//Space complexity: O(n) for recursive calls
public List<String> letterCombinations(String digits) {
    if(digits.length() == 0) return new ArrayList<String>();
	Map<Character, Character[]> map = new HashMap<>();
	map.put('2', new Character[]{'a','b','c'});
	map.put('3', new Character[]{'d','e','f'});
	map.put('4', new Character[]{'g','h','i'});
	map.put('5', new Character[]{'j','k','l'});
	map.put('6', new Character[]{'m','n','o'});
	map.put('7', new Character[]{'p','q','r','s'});
	map.put('8', new Character[]{'t','u','v'});
	map.put('9', new Character[]{'w','x','y','z'});

	List<String> res = new ArrayList<>();
	char[] arr = new char[digits.length()];
	util(map, res, arr, digits, 0);
	return res;
}

private void util(Map<Character, Character[]> map, List<String> res, char[] arr, String digits, int index){
	if(index == digits.length()) {
		res.add(String.valueOf(arr));
		return;
	}
	else{
		Character[] tmp = map.get(digits.charAt(index));
		for(int i = 0; i < tmp.length; i++){
			arr[index] = tmp[i];
			util(map, res, arr, digits, index+1);
		}
	}
}