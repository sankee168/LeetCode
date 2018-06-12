public ListNode reverseBetween(ListNode head, int m, int n) {
	if(head == null || head.next == null || m == n) return head;

	int i = 1;

	ListNode temp = new ListNode(-1);
	temp.next = head;
	ListNode p = temp;
	while(i < m){
		p = p.next; i++;
	}

	ListNode firstTail = p;
	ListNode reverseStart = p.next;
	
	while(i <= n){
		p = p.next; i++;
	}

	ListNode lastStart = p.next;
	p.next = null;
	firstTail.next = null;
	firstTail.next = reverse(reverseStart);
	reverseStart.next = lastStart;
	return temp.next;        
}

private ListNode reverse(ListNode head){
	if(head == null || head.next == null) return head;
	ListNode p = head;
	ListNode q = head.next;
	while(p != null && q != null){
		ListNode temp = q.next;
		q.next = p;
		p = q;
		q = temp;
	}

	head.next = null;
	return p;
}