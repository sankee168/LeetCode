//this is also a sliding window problem. we have to keep the counter in the map
//when the map count of chars go > 2 then we have to start moving from start till we see only 2 chars
//Time complexity: O(n)
//Space complexity: O(1)
public int lengthOfLongestSubstringTwoDistinct(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    int i = 0, j = 0;
    int maxLen = 0;
    int n = s.length();
    while(j < n){
        char end = s.charAt(j);
        map.put(end, map.getOrDefault(end, 0)+1);
        if(map.get(end) == 1) count++;
        if(count > 2){
            char start = s.charAt(i);
            if(map.get(start) == 1){
                count--;
            }
            map.put(start, map.get(start)-1);
            i++;
        }
        maxLen = Math.max(maxLen, j-i+1);
        j++;
    }        
    return maxLen;
}