class MapSum {
    class TrieNode{
        Map<Character, TrieNode> charMap;
        int val;

        public TrieNode(){
            charMap = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for(int i = 0; i < key.length(); i++){
            char tmp = key.charAt(i);
            if(!cur.charMap.containsKey(tmp)){
                cur.charMap.put(tmp, new TrieNode());
            }
            cur = cur.charMap.get(tmp);
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char tmp = prefix.charAt(i);
            if(!cur.charMap.containsKey(tmp)){
                cur.charMap.put(tmp, new TrieNode());
            }
            cur = cur.charMap.get(tmp);
        }
        return findSum(cur);
    }

    private int findSum(TrieNode cur){
        int sum = cur.val;
        for(TrieNode currNode : cur.charMap.values()){
            sum += findSum(currNode);
        }

        return sum;
    }
}