//Time complexity: O(n)
//Space complexity: O(n) where n is the sum of length of words
public int uniqueMorseRepresentations(String[] words) {
    String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < words.length; i++){
        StringBuilder sb = new StringBuilder();
        char[] curr = words[i].toCharArray();
        for(char p : curr){
            sb.append(arr[p-'a']);
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0));
    }        
    return map.keySet().size();
}