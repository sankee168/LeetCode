//we create the array of 256 as there can be 256 chars. 
//here we create two int arrays for each of the strings
//we keep track of mapping by increasing the index value in each of the chars position
//if we see mismatch in the order, the value in each of the index differs
//Time complexity: O(n) where n is the length of the string
//Space complexity: O(1) as we are using constant space
public boolean isIsomorphic(String s, String t) {
    int[] t1 = new int[256];
    int[] t2 = new int[256];
    for(int i = 0; i < s.length(); i++){
        if(t1[s.charAt(i)] != t2[t.charAt(i)]) return false;
        t1[s.charAt(i)] += (i+1);
        t2[t.charAt(i)] += (i+1);
    }
    return true;
}

//This solution works too. 
//we have a map to store the mapping of characters
//if we dont have key character and values has mapping char, then it is false
//else if it contains key and value map differs, it is false
//Time complexity: O(n)
//Space complexity: O(n)
public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()) return false;
    Map<Character, Character> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
        if(map.containsKey(s.charAt(i))){
            if(map.get(s.charAt(i)) != t.charAt(i)) return false;
        }else{
            if(map.containsValue(t.charAt(i))) return false;
            map.put(s.charAt(i), t.charAt(i));
        }
    }
    return true;
}