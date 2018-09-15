//Idea here is to store list of indices per word in a map
//and when shortest method is called, we have to compute the shortest distance between two
//time complexity: shortest method is of O(m+n) where m, n are occurences of the word in input
//Space complexity: O(k) worst case where k is the size of words
//Other approach is to precompute the distance on the input itself.
class WordDistance {
    
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        return getMin(l1, l2);
    }
    
    private int getMin(List<Integer> l1, List<Integer> l2){
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()){
            int t1 = l1.get(i);
            int t2 = l2.get(j);
            min = Math.min(Math.abs(t1 - t2), min);
            if(t1 < t2) i++;
            else if(t2 < t1) j++;
            else return 0;
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */