//here we calculate the length of each linkedlist and traverse the difference in one
//now as they are of same length, they should be intersecitng at the some point
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	int l1 = length(headA);
	int l2 = length(headB);

	if(l1 > l2) return util(headA, headB, l1-l2);
	else return util(headB, headA, l2-l1);
}

private util(ListNode headA, ListNode headB, int diff){
	ListNode l1 = headA;
	ListNode l2 = headB;
	while(diff > 0){
		l1 = l1.next;
		diff--;
	}

	while(l1 != null && l2 != null l1 != l2){
		l1 = l1.next;
		l2 = l2.next;
	}
	
	if(l1 == null || l2 == null) return null;
	return l1;
}

private int length(ListNode head){
	ListNode p = head;
	int l = 0;
	while(p != null){
		p = p.next;
		l++;
	}
	return l;
}


//we start with two heads of lists
//when we reach end of it we point to other head
//this way after one iteration of two pointers we will have two pointers at equidistant from intersection
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	ListNode p = headA;
	ListNode q = headB;
	while(p != q){
		if(p == null) p = headB;
		else p = p.next;
		if(q == null) q = headA;
		else q = q.next;
	}
	return p;
}