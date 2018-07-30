//Time complexity: O(n)
//Space complexity: O(1)
public ListNode middleNode(ListNode head) {
	if(head == null) return head;
	ListNode slow = head;
	ListNode fast = head.next;
	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
	}

	if(fast != null) return slow.next;
	return slow;
}	