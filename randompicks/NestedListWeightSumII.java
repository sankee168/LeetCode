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
//We can extend the previous solution itself, We have to calculate the maxDepth no matter what. So we keep doing dfs, on each 
//element, we update the maxDepth. and push its current depth and curr value into another two stacks.
//at the end of traversal we will have elements and corresponding depths in the stack and maxDepth in another variables
//pop all the elements and calculate the maxdepth
//Time complexity: O(n)
//Space complexity: O(n) but we can optimize this
class Solution {
	int maxDepth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<Integer> elementStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        for(NestedInteger curr: nestedList){
        	dfs(curr, elementStack, depthStack, 0);
        }
        int val = 0;
        while(!elementStack.isEmpty()){
        	val += elementStack.pop()*(maxDepth-depthStack.pop());
        }

        return val;
    }

    private void dfs(NestedInteger element, Stack<Integer> elementStack, Stack<Integer> depthStack, int depth){
    	maxDepth = Math.max(depth+1, maxDepth);
    	if(element.isInteger()) {
    		elementStack.push(element.getInteger()); 
    		depthStack.push(depth);
    	}else{
    		for(NestedInteger curr: element.getList()){
    			dfs(curr, elementStack, depthStack, depth+1);
    		}
    	}
    }
}

//Here we are not waiting till we know the maxDepth, we keep on adding the sum of previous all levels to result
//so that first level will be added n times where n will be depth of the list
//Time complexity : O(n)
//Space compelxity: O(n)
class Solution {
	public int depthSumInverse(List<NestedInteger> nestedList) {
    	Queue<NestedInteger> queue = new LinkedList<>();
    	for(NestedInteger curr: nestedList) queue.add(curr);
    	int result = 0;
    	int unweightedSum = 0;
    	while(!queue.isEmpty()){
            int size = queue.size();
    		for(int i = 0; i < size; i++){
    			NestedInteger curr = queue.poll();
    			if(curr.isInteger()){
    				unweightedSum += curr.getInteger();
    			}else{
    				for(NestedInteger child: curr.getList()){
    					queue.add(child);
    				}
    			}
    		}
    		result += unweightedSum;
    	}
    	return result;
    }
}


