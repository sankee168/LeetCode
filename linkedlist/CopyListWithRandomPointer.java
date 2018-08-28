//Idea here is to keep a map of each node's clone and then iterate over the list again and 
//keep assigning next and random pointers to its clone
//Time complexity: O(n)
//Space complexity: O(n)
public RandomListNode copyRandomList(RandomListNode head) {
	RandomListNode p = head;
	Map<RandomListNode, RandomListNode> map = new HashMap<>();
	while(p != null){
		map.put(p, new RandomListNode(p.label));
		p = p.next;
	}

	p = head;
	while(p != null){
		map.get(p).next = map.get(p.next);
		map.get(p).random = map.get(p.random);
		p = p.next;
	}

	return map.get(head);
}

//Can we optimize this solution?
//We can bring down the space complexity to O(1) by not using the map
//For this we will go through 3 steps
//1. Iterate the head and keep cloning the curr node and assign it as its next. 
//   which means every node's clone will be just adjacent to each other
//2. Iterate over the list again and assign random pointers too
//3. Split the current list to new cloned list
public RandomListNode copyRandomList(RandomListNode head) {
	RandomListNode  p = head;
	while(p != null){
		RandomListNode temp = p.next;
		RandomListNode clone = new RandomListNode(p.label);
		p.next = clone;
		clone.next = temp;
		p = p.next.next;
	}

	p = head;
	while(p != null){
		if(p.random != null) p.next.random = p.random.next;
		p = p.next.next;
	}

	RandomListNode temp = new RandomListNode(-1);
	RandomListNode q = temp;
	p = head;
	while(p != null){
		q.next = p.next;
		q = q.next;
		p.next = p.next.next;
		p = p.next;
	}
	return temp.next;
}