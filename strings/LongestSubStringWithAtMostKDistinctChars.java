//Have a sliding window from i to j index
//while moving j determine if unique char go beyond k
//then keep moving i such that whenever you remove another char from the window, you can keep moving j
//Time complexity: O(n)
//Space complexity: O(n)
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    int res = 0;
    int i = 0, j = 0;
    while(j < s.length()){
        if(!map.containsKey(s.charAt(j))){
            count++;
            map.put(s.charAt(j), 1);
        }else{
            map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
        }
        while(i <= j && count > k){
            int freq = map.get(s.charAt(i));
            if(freq == 1){
                map.remove(s.charAt(i));
                count--;
            }else{
                map.put(s.charAt(i), freq-1);
            }
            i++;
        }                
        res = Math.max(res, j-i+1);
        j++;
    }
    return res;
}