public class ZigzagIterator {
    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    boolean isFirst;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
        isFirst = true;
    }

    public int next() {
        if(isFirst){
            isFirst = false;
            if(iter1.hasNext()){
                return iter1.next();
            }else{                
                return next();
            }
        }else{
            isFirst = true;
            if(iter2.hasNext()){
                return iter2.next();
            }else{
                return next();
            }
        }
    }

    public boolean hasNext() {
        return (iter1.hasNext() || iter2.hasNext());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

//We can make this easy by haing queue of iterator. this can be extended to k lists too
public class ZigzagIterator {
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        Iterator<Integer> iter1 = v1.iterator();
        Iterator<Integer> iter2 = v2.iterator();
        if(iter1.hasNext()) iter.add(iter1);
        if(iter2.hasNext()) iter.add(iter2);
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int temp = iter.next();
        if(iter.hasNext()) queue.add(iter);
        return temp;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}