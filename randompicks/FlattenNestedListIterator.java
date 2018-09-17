//Interesting idea is to visualize the nested iterator as tree and and when you see an internal nested do dfs
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Integer> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size()-1; i >= 0; i--){
            NestedInteger curr = nestedList.get(i);
            if(curr.isInteger()) stack.push(curr.getInteger());
            else{
                dfs(curr);
            }
        }
    }

    private void dfs(NestedInteger node){
        List<NestedInteger> list = node.getList();
        for(int i = list.size()-1; i >= 0; i--){
            NestedInteger curr = list.get(i);
            if(curr.isInteger()) stack.push(curr.getInteger());
            else{
                dfs(curr);
            }
        }
    }


    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


//Here we are storing iterator objects in the stack
public class NestedIterator implements Iterator<Integer> {

    Iterator<NestedInteger> iter;
    Stack<Iterator<NestedInteger>> stack;
    Integer next;
    public NestedIterator(List<NestedInteger> nestedList) {
        iter = nestedList.iterator();
        stack = new Stack<>();
    }

    @Override
    public Integer next() {
        return next;
    }

    @Override
    public boolean hasNext() {
        if(iter == null) return false;
        while(iter.hasNext() || !stack.isEmpty()){
            if(!iter.hasNext()) iter = stack.pop();
            else{
                NestedInteger temp = iter.next();
                if(temp.isInteger()) {
                    next = temp.getInteger();
                    return true;
                }else{
                    if(temp.getList().size() > 0){
                        stack.push(iter);
                        iter = temp.getList().iterator();
                    }
                }
            }
        }
        return false;
    }
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size()-1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()) return true;
            NestedInteger temp = stack.pop();
            for(int i = temp.getList().size()-1; i >= 0; i--){
                stack.push(temp.getList().get(i));
            }
        }
        return false;
    }
}
