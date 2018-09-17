/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//Here we are usig stack to store the iterators, on every encounter of list we store the iterator in the stack
//and when we see that is end of the list, we pop the iterator stack and resume that iterator
//Time complexity: o(n) where n is the total number of integers in the nestedList
//Space complexity: O(n) 
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int val = 0; int depth = 1;
        Stack<Iterator> stackIterator = new Stack<>();
        Iterator<NestedInteger> iter = nestedList.iterator();
        while(iter.hasNext()){
        	NestedInteger curr = iter.next();
        	if(curr.isInteger()){
                System.out.println(curr.getInteger()*depth);
        		val += (curr.getInteger()*depth);
        	}else{
        		stackIterator.push(iter);
        		iter = curr.getList().iterator();
        		depth = depth+1;
        	}

        	while(!iter.hasNext() && !stackIterator.isEmpty()){
        		depth = depth-1;
        		iter = stackIterator.pop();
        	}
        }
        return val;
    }
}

//We can do this simple way buy doing dfs on every nestedelement
//Space compelxity: O(n) for recursive stack
//Time complexity: O(n) where n is the number of elements
public int depthSum(List<NestedInteger> nestedList) {
    int val = 0; int depth = 1;
   	for(NestedInteger curr: nestedList){
   		val += dfs(curr, 1);
   	}
    return val;
}

private int dfs(NestedInteger curr, int depth){
	if(curr.isInteger()) return curr.getInteger()*depth;
	int res = 0;
	for(NestedInteger child :curr.getList()){
		res += dfs(child, depth+1);
	}
	return res;
}

//This is another bfs sort of solution keeping track of height of each node
public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger curr: nestedList) queue.add(curr);
        int sum = 0;
        int height = 1;
        while(!queue.isEmpty()){
            int size  = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger curr = queue.poll();
                if(curr.isInteger()){
                    sum += (curr.getInteger()*height);
                }else{
                    for(NestedInteger sub : curr.getList()){
                        queue.add(sub);
                    }
                }
            }
            height++;
        }
        return sum;
    }
