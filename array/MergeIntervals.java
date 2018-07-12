//Sort the interval based on the start of interval
//keep checking the previous end is greater than start of curr. if so merge them. 
//Time complexity: sorting taken O(nlogn) other than that merge is just single traversal
//Space complexity: O(1) not considering result array.
private class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b){
		if(a.start > b.start) return 1;
		else if(a.start == b.start) return 0;
		return -1;
	}
}

public List<Interval> merge(List<Interval> intervals) {
	List<Interval> res = new ArrayList<>();
	Collections.sort(intervals, new IntervalComparator());
	Interval prev = null;
	for(Interval curr: intervals){
		if(prev == null) prev = curr;
		else if(prev.end >= curr.start){
			prev.end = Math.max(prev.end, curr.end);
		}else {res.add(prev); prev = curr;}
	}

	if(prev != null) res.add(prev);
	return res;
}