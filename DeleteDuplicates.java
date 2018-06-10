public ListNode deleteDuplicates(ListNode head) {
	if(head == null || head.next == null) return head;
	ListNode temp = new ListNode(-1);
	temp.next = head;
	ListNode p = temp;
	while(p.next != null && p.next.next != null){
		if(p.next.val == p.next.next.val){
			int val = p.next.val;
			while(p.next != null && p.next.val == val){
				p.next = p.next.next;
			}
		}else{
			p = p.next;
		}
	}

	return temp.next;
}