/**
*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
*reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
*
*You may not modify the values in the list's nodes, only nodes itself may be changed.
*
*Example 1:
*
*Given 1->2->3->4, reorder it to 1->4->2->3.
*Example 2:
*
*Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/
public void reorderList(ListNode head) {

	if(head == null || head.next == null){
		return;
	}
	ListNode slow = head;
	ListNode fast = head.next;

	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
	}

	ListNode p = slow.next;
	slow.next = null;
	ListNode q = reverse(p);
	ListNode d = head;
	p = head.next;

	while(p != null || q != null){

		if(q != null){
			d.next =q;
			q = q.next;
			d = d.next;
		}

		if(p != null){
			d.next = p;
			p = p.next;
			d =d.next;
		}
	}

}

private ListNode reverse(ListNode head){
	if(head == null || head.next == null){
		return head;
	}
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