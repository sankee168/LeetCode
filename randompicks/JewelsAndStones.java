//Time complexity: O(m+n)
//Space complexity: O(m) where m is the length of J and n is the length of S
public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < J.length(); i++){
        set.add(J.charAt(i));
    }
    int count = 0;
    for(int i = 0; i < S.length(); i++){
        if(set.contains(S.charAt(i))) count++;
    }
    return count;
}