public class LinkedList<T> implements Iterable<T>{

    private ListNode<T> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    //adds node to the end of the list
    public void add(T e){
        ListNode<T> node = new ListNode(e);
        if(head == null) head = node;
        else{
            ListNode p = head;
            while(p.next != null) p = p.next;
            p.next = node;
        }

        size++;
    }

    //removes the head of the list
    public void remove(){
        if(head == null) throw new NoSuchElementException("No element found at index 0");
        head = head.next;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(T e){
        ListNode p = head;
        if(p == null) return false;
        while(p != null){
            if(p.val == e) return true;
            p = p.next;
        }
        return false;
    }

    public void addFirst(T e){
        ListNode<T> node = new ListNode(e);
        node.next = head;
        head = node;
    }

    public void addLast(T e){
        ListNode<T> node = new ListNode(e);
        ListNode<T> p = head;
        if(head == null) head = node;
        else{
            while(p.next != null) p = p.next;
            p.next = node;
        }
    }

    public T getFirst(){
        if(head == null) throw new NoSuchElementException("no such element at head");
        return head.val;
    }

    public T getLast(){
        if(head == null) throw new NoSuchElementException("no such element at head");
        ListNode<T> p = head;
        while(p.next != null) p = p.next;

        return p.val;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private ListNode<T> nextNode;
        public ListIterator(){
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            if(nextNode == null) return false;
            return true;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("no such element");
            }
            T e = nextNode.val;
            nextNode = nextNode.next;
            return e;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }
}