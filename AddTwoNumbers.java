public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode dump = new ListNode(-1);
	ListNode temp = dump;
	if(l1 == null) return l2;
	if(l2 == null) return l1;
	int carry = 0;
	while(l1 != null || l2 != null){
		int val = carry;

		if(l1 != null){
			val+= l1.val;
			l1 = l1.next;
		}
		if(l2 != null){
			val += l2.val;
			l2 = l2.next;
		}

		ListNode p = new ListNode(val%10);
		carry = val/10;
		temp.next = p;
		temp = temp.next;
	}
	
	if(carry == 1){
		ListNode p = new ListNode(1);
		temp.next = p;
	}

	return dump.next;
}