//we first create a map with char and frequency
//we maintain the sliding window keep incrementing j. when we have all the characters, then we add start index to the list
//and keep iterating the start index till we break the count
//Time complexity: O(n)
//Space complexity: O(n) but we can use the array of 26 integer as everything is lower case 
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < p.length(); i++){
        map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
    }
    int count = p.length();
    int i = 0, j = 0;
    while(j < s.length()){
        char end = s.charAt(j);
        if(map.containsKey(end)){
            map.put(end, map.get(end)-1);
            if(map.get(end) >= 0) count--;
        }            
        while(count == 0){
            char start = s.charAt(i);
            if(map.containsKey(start)){
                map.put(start, map.get(start)+1);
                if(map.get(start) > 0) count++;
            }                
            if(j-i+1 == p.length()) list.add(i);
            i++;
        }
        j++;
    }
    return list;
}