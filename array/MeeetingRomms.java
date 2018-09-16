//Meeting Rooms
//Time complexity: O(nlogn). Sorting takes O(nlogn) or rest is just a linear traversal
//Space complexity: o(1)
private class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval a, Interval b){
		if(a.start > b.start)return 1;
		else if(a.start == b.start)return 0;
		return -1;
	}
}

public boolean canAttendMeetings(Interval[] intervals) {
	Arrays.sort(intervals, new IntervalComparator());
	for(int i = 1; i < intervals.length; i++){
		if(intervals[i].start < intervals[i-1].end){
			return false;
		}
	}
	return true;
}