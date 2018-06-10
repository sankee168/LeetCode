public ListNode detectCycle(ListNode head) {
	if(head == null || head.next == null) return null;
	
	ListNode pt2 = detectLoop(head);

	if(pt2 == null){
		return null;
	}

	ListNode pt1 = head;

	while(pt1 != pt2){
		pt1 = pt1.next;
		pt2 = pt2.next;
	}

	return pt2;
}

private ListNode detectLoop(ListNode head){
	ListNode fast = head;
	ListNode slow = head;
	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast){
			return slow;
		}
	}
	return null;
}