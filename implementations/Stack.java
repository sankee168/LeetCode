public class Stack<T> implements Iterable <T>{

    int size;
    Node<T> head;

    public Stack(){
        head = null;
        size = 0;
    }

    public void push(T e){
        Node<T> node = new Node(e);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public T pop(){
        if(size == 0) throw new NoSuchElementException("no such element");
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.val;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<T>{

        Node<T> next;

        public NodeIterator(){
            next = head;
        }

        @Override
        public boolean hasNext() {
            return !(next == null);
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException("no such element");
            Node<T> temp = next;
            next = next.next;
            return temp.val;
        }

        @Override
        public void remove() {
            return;
        }
    }

    class Node<T> {
        T val;
        Node next;

        public Node(T val){
            this.val = val;
            next = null;
        }
    }
}
