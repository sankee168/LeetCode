//Idea here is to sort given intervals with start time and have min heap based on the end time to keep track of first ending meeting time
//Time complexity : O(nlogn)
//Space complexity: O(n) for min heap
private class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval a, Interval b){
		if(a.start > b.start) return 1;
		if(a.start == b.start) return 0;
		return -1;
	}
}

private class IntervalEndComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer a, Integer b){
		if(a > b) return 1;
        if(a == b) return 0;
        return -1;
	}
}

public int minMeetingRooms(Interval[] intervals) {
    if(intervals.length == 0) return 0;
	Arrays.sort(intervals, new IntervalComparator());
	PriorityQueue<Integer> ends = new PriorityQueue<>(intervals.length, new IntervalEndComparator());
	int count = 0;
	for(int i = 0; i < intervals.length; i++){
		Interval curr = intervals[i];
		
		if(ends.peek() == null){
			count++;
			ends.offer(curr.end);
		}else {
			if(ends.peek() <= curr.start){
				ends.poll();
				ends.offer(curr.end);
			}else{
				count++;
				ends.offer(curr.end);
			}
		}
	}
	return count;	
}