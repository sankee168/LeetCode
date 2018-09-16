//Time complexity: O(m+n)
//Space complexity: O(1)
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode tempHead = new ListNode(-1);
	ListNode p = tempHead;
	while(l1 != null && l2 != null){
		if(l1.val < l2.val){
			p.next = l1;
			l1 = l1.next;
		}else{
			p.next = l2;
			l2 = l2.next;
		}
		p = p.next;
	}

	if(l1 != null) p.next = l1;
	if(l2 != null) p.next = l2;
	return tempHead.next;
}