//Step1: find the length of the linkedlist
//Step2: see how many iterations does it take
//Step3; at each iteration reverse k nodes and return back
//Time complexity: O(n)
public ListNode reverseKGroup(ListNode head, int k) {
	int n = length(head);
	ListNode fakeHead = new ListNode(-1);
    fakeHead.next = head;
	ListNode p = fakeHead;
	ListNode q = head;
	for(int i = 0; i < n/k; i++){
		p.next = reverse(q, k);
		int count = 0;
		while(count < k){
			p = p.next;
            count++;
		}
		q = p.next;
	}
	return fakeHead.next;
}

private int length(ListNode head){
	ListNode p = head;
	int count = 0;
	while(p != null){
		count++;
		p = p.next;
	}
	return count;
}

private ListNode reverse(ListNode head, int k){
	ListNode p = head;
	ListNode q = p.next;
	while(q != null && k > 1){
		ListNode tmp = q.next;
		q.next = p;
		p = q;
		q = tmp;
		k--;
	}
	head.next = q;
	return p;
}