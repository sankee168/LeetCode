//Here we maintian two heaps. left heap contains all the elements which are lower than median
//and right heap contains greater than median
//left heap is max heap and right heap is the min heap
//Time complexity: O(logn)
//At any point we will have maximum of 1 element difference between two heaps
class MedianFinder {
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    double median;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == 0 && right.size() == 0) {
        	left.add(num);
        	median = num;
        }else{
        	if(num > median){
        		right.add(num);
        	}else left.add(num);

        	if(left.size() == right.size()){
        		median = (left.peek()+right.peek())/(double)2;
        	}
        	else if(left.size()-right.size() == 1){
        		median = left.peek();
        	}else if(left.size()-right.size() == -1){
        		median = right.peek();
        	}else if(left.size()-right.size() == 2){
        		right.add(left.poll());
        		median = (left.peek()+right.peek())/(double)2;
        	}else if(left.size()-right.size() == -2){
        		left.add(right.poll());
        		median = (left.peek()+right.peek())/(double)2;
        	}
        }
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */