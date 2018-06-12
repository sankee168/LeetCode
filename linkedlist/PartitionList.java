public ListNode partition(ListNode head, int x) {

    if(head == null || head.next == null){
        return head;
    }

    ListNode pHead = new ListNode(-1);
    ListNode qHead = new ListNode(-1);
    ListNode p = pHead;
    ListNode q = qHead;
    while(head != null){
        if(head.val < x){
            p.next = head;
            p = p.next;
        }else{
            q.next = head;
            q = q.next;
        }
        head = head.next;
    }
    q.next = null; 
    p.next =qHead.next;
    return pHead.next;
}