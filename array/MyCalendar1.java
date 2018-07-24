//This is simple. 
//Time complexity: O(n2)
//Space complexity: O(n)
class MyCalendar {
	List<Interval> list;

	class Interval {
		int start;
		int end;

		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {    	
        for(int i = 0; i < list.size(); i++){
        	Interval curr = list.get(i);
        	if(end > curr.start && start < curr.end) return false;        	     
        }
        list.add(new Interval(start, end));
        return true;
    }
}

//How can we optimize above approach?
//Rather than traversing through the complete list, if we can put each interval in sorted manner we can decrease the search to logn 
//For this we will be using Treemap where it keeps all the entries in sorted
class MyCalendar {
	TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {    	
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if((prev == null || map.get(prev) <= start) && (next == null || end <= next)){
			map.put(start, end);
			return true;
		}
        return false;
    }
}