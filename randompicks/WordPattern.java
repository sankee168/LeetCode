//here idea is majorly similar to isomorphic strings
//Time complexity: O(n)
//Space complexity: O(n)
public boolean wordPattern(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    String[] arr = str.split(" ");
    if(pattern.length() != arr.length) return false;
    for(int i = 0; i < pattern.length(); i++){
        char c = pattern.charAt(i);
        String word = arr[i];
        if(!map.containsKey(c)){
            if(map.containsValue(word)) return false;
            else{
                map.put(c, word);    
            }
        }else{
            if(!map.get(c).equals(word)) return false;
        }
    }
    return true;
}