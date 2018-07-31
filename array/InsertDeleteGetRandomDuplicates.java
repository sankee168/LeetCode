class RandomizedCollection {
    
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContains = false;
        Set<Integer> set = new HashSet<>();
        if(map.keySet().contains(val)) {
            isContains = true;
            set = map.get(val);
        }
        list.add(val);
        set.add(list.size()-1);        
        map.put(val, set);
        return !isContains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.keySet().contains(val)) return false;
        Set<Integer> curr = map.get(val);
        int index = curr.iterator().next();
        if(!map.get(val).contains(list.size()-1)){
            int replaceElement = list.get(list.size()-1);
            list.set(list.size()-1, val);
            list.set(index, replaceElement);
            map.get(replaceElement).remove(list.size()-1);
            map.get(replaceElement).add(index);
            map.get(val).remove(index);
            map.get(val).add(list.size()-1);
        }
        map.get(val).remove(list.size()-1);
        if(map.get(val).size() == 0) map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int mainIndex = rand.nextInt(list.size());
        return list.get(mainIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */