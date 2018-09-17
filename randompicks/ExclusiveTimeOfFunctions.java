//As we read the question, we get a slight idea of using stack as this resembles call stack
//so when there is end of certian function, we pop else we add to the stack
//in this process, we need to update the execution times
//if it is end of a function, then we append extra +1 as execution includes start and end.
//else just append the difference
//main idea to not to forget the current time
//time complexity: O(n) where n is the size of logs
//space complexity: O(n/2) as there can be atmax of n/2 entries in stack
public int[] exclusiveTime(int n, List<String> logs) {
	int[] res = new int[n];
	Stack<Integer> stack = new Stack<>();
	String[] temp = logs.get(0).split(":");
	int function = Integer.parseInt(temp[0]);
	int time = Integer.parseInt(temp[2]);
	stack.push(function);
	for(int i = 1; i < logs.size(); i++){
		String curLog = logs.get(i);
		String[] log = curLog.split(":");
		int nextFunction = Integer.parseInt(log[0]);
		int nextTime = Integer.parseInt(log[2]);
		if(log[1].equals("start")){
            if(!stack.isEmpty()) res[stack.peek()] += nextTime-time;
			stack.push(nextFunction);
			time = nextTime;
		}else{
			res[nextFunction] += nextTime-time+1;
			stack.pop();
			time = nextTime+1;
		}
	}
	return res;
}