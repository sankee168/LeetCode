//Key here is to define TreeNode class. Lets say our input is just from the lower case characters. 
//So at each level, there can be 26 chidren to each node. So we used map to store that character to child mapping
//So when we are inserting a word into trie, each character will go into single node at different level
//Why did we keep isWord boolean, this is to check if that is the actual word or not
//Lets say n is the length of longest word, then there will be n+1 levels
//So time complexity for insert, search and startswith will be O(n)
//Lets say if we have m words and length of longest word is n then space complexity will be O(mnk) worst 
//where k is the number of different characters here it is 26
class Trie{
	class TrieNode{
		public boolean isWord;
		public Map<Character, TrieNode> childrenMap;
        
        public TrieNode(){
		    childrenMap = new HashMap<>();
            isWord = false;
	    }
	}

	private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

	public void insert(String s){
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++){
			if(!cur.childrenMap.containsKey(s.charAt(i))){
				cur.childrenMap.put(s.charAt(i), new TrieNode());
			}

			cur = cur.childrenMap.get(s.charAt(i));
		}

		cur.isWord = true;
	}

	public boolean search(String s){
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(!cur.childrenMap.containsKey(tmp)) return false;
			cur = cur.childrenMap.get(tmp);
		}
		return cur.isWord;
	}

	public boolean startsWith(String s){
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(!cur.childrenMap.containsKey(tmp)) return false;
			cur = cur.childrenMap.get(tmp);
		}
		return true;
	}
}