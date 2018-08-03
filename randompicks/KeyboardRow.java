//Time complexity: O(n*k) where n is the length of words and k is the average length of strings
//Space complexity: O(n) for storing the result strings
public String[] findWords(String[] words) {
	int[] arr = new int[26];
	char[] one = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
	char[] two = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
	for(int i = 0; i < one.length; i++){
		arr[one[i]-'a'] = 1;
	}

	for(int i = 0; i < two.length; i++){
		arr[two[i]-'a'] = 2;
	}

	List<String> list = new ArrayList<>();
	for(int i = 0; i < words.length; i++){
		String curr = words[i];
		int line = arr[Character.toLowerCase(curr.charAt(0)) - 'a'];
		int j = 1;
		while(j < curr.length() && arr[Character.toLowerCase(curr.charAt(j))-'a'] == line) j++;
		if(j == curr.length()) list.add(curr);
	}

	String[] res = new String[list.size()];
	for(int i = 0; i < list.size(); i++){
		res[i] = list.get(i);
	}

	return res;
}