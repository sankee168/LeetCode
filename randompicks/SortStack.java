//We are given stack. we have to sort stack just by using another stack
//Time complexity; O(n2)
//Space compelxity: O(n)
//Idea here is to pop one element from s1 and keep it in right place in s2. 
//If we see that top of s2 is lesser than s1, that means curr element should be below those elements. so put thos elements back in original stack
public static Stack<Integer> sort(Stack<Integer> s1){
    Stack<Integer> s2 = new Stack<>();
	while(!s1.isEmpty()){
		int curr = s1.pop();
		while(!s2.isEmpty() && s2.peek() < curr){
			s1.push(s2.pop());
		}

		s2.push(curr);
	}
	return s2;
}