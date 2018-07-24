//Extending MyCalendar1 solution by maintaining intersection in duplicates list.
//Time complexity: O(n2)
//Space complexity: O(1)
class MyCalendarTwo {

	List<Interval> list;
	List<Interval> duplicates;
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
        duplicates = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    	for(int i = 0; i < duplicates.size(); i++){
        	Interval curr = duplicates.get(i);
        	if(end > curr.start && start < curr.end) return false;        	     
        }

        for(int i = 0; i < list.size(); i++){
        	Interval curr = list.get(i);
        	if(end > curr.start && start < curr.end) {
        		duplicates.add(new Interval (Math.max(start, curr.start), Math.min(end, curr.end)));
        	}        	     
        }
        list.add(new Interval(start, end));
        return true;
    }
}
