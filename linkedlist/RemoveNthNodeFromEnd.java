public ListNode removeNthFromEnd(ListNode head, int n) {
	if(head == null || head.next == null) return null;
	int i = 0;
	ListNode p = head;
	ListNode q = new ListNode(-1);
	q.next = head;
	while(i != n){
		p = p.next;
		i++;
	}

	if(p == null){
		head = head.next;
		return head;
	}

	while(p != null){
		p = p.next;
		q = q.next;
	}

	q.next = q.next.next;
	return head;
}