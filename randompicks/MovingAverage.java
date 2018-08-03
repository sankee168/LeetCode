//Time complexity: O(1)
class MovingAverage {
    
    int maxSize;
    Queue<Integer> list;
    double average;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.maxSize = size;
        list = new LinkedList<>();
        average = 0;
    }
    
    public double next(int val) {
        if(list.size() < maxSize) {
            list.add(val);
            average = (average*(list.size()-1) + val)/((double) list.size());
        }else{
            int first = list.remove();
            list.add(val);
            average = (average*maxSize - first + val)/((double) list.size());            
        }
        return average;
    }
}