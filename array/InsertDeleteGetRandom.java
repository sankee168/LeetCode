//Note that set doesn't have get(index) functionality as there is no order associated to it. 
class RandomizedSet {

    //this stores the value to list index mapping
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.keySet().contains(val)) return false;
        else{
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    //if index of this value is not last of list, then complexity will shoot out of O(n)
    //rather we update the map by setting the index value to last value in list
    //and deleting the last value
    public boolean remove(int val) {
        if(!map.contains(val)) return false;
        int index = map.get(val);
        if(index != list.size()-1){
            int lastVal = list.get(list.size()-1);
            map.put(lastVal, index);
            list.set(index, lastVal); 
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.getNextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */