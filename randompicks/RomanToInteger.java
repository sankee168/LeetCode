//Idea here is if there is larger value in the next index, then result
//will have of next-previous. So in current iteration we substract curr.
//Time complexity: O(n) where n is the length of string
public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('V', 5);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        int sum = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else sum += map.get(s.charAt(i));
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;
    }