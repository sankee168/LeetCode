//We have a map with key and frequency of that key
//here we do add operation in O(1) and find in O(k) where k is the unique elements added worst case this can go to O(n)
//Space complexity: O(1)
class TwoSum {

	Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
    	map = new HashMap<>();    
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key1 : map.keySet()){
        	int key2 = value-key1;
        	if(key1 == key2 && map.get(key1) > 1) return true;
        	else if(key1 != key2 && map.containsKey(key2)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

//We can make add costly by having all the values which can be created with existing numbers
//Time complexity: O(n) for add operation and O(1) for find operation
//Space complexity: O(n)
class TwoSum {

	Map<Integer, Integer> map;
	Set<Integer> values;

    /** Initialize your data structure here. */
    public TwoSum() {
    	map = new HashMap<>();
    	values = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number) && map.get(number) > 1) return;
        for(int curr: map.keySet()){
        	values.add(curr + number);
        }
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return values.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */