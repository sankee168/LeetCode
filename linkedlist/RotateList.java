/**
*Given a linked list, rotate the list to the right by k places, where k is non-negative.
*
*Example 1:
*
*Input: 1->2->3->4->5->NULL, k = 2
*Output: 4->5->1->2->3->NULL
*Explanation:
*rotate 1 steps to the right: 5->1->2->3->4->NULL
*rotate 2 steps to the right: 4->5->1->2->3->NULL
*Example 2:
*
*Input: 0->1->2->NULL, k = 4
*Output: 2->0->1->NULL
*Explanation:
*rotate 1 steps to the right: 2->0->1->NULL
*rotate 2 steps to the right: 1->2->0->NULL
*rotate 3 steps to the right: 0->1->2->NULL
*rotate 4 steps to the right: 2->0->1->NULL
*/

public ListNode rotateRight(ListNode head, int k) {
	if(k == 0 || head == null || head.next == null) return head;
	int length = length(head);
	int movePositions = k%length;
	if(movePositions == 0) return head;

	ListNode p = head;
	while(p != null && movePositions > 0){
		p = p.next;
		movePositions--;
	}

	ListNode q = new ListNode(-1);
	q.next = head;
	while(p != null){
		p = p.next;
		q = q.next;
	}

	ListNode newHead = q.next;
	q.next = null;
	p = newHead;
	while(p.next != null){
		p = p.next;
	}

	p.next = head;
	return newHead;
}

private int length(ListNode head){
	int l = 0;
	ListNode p = head;
	while(p != null){
		l++;
		p = p.next;
	}

	return l;
}