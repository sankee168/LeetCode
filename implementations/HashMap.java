public class HashMap<T, K> {

    Entry<T, K>[] arr;
    private int capacity = 100;

    public HashMap(){
        arr = new Entry[capacity];
    }

    public void put(T key, K value){
        int pos = hash(key);
        Entry<T, K> entry = new Entry(key, value);
        if(arr[pos] == null){
            arr[pos] = entry;
        }else{
            Entry head = arr[pos];
            Entry prev = null;
            while(head != null && head.key != key){
                prev = head;
                head = head.next;
            }

            if(head != null) head.value = value;
            else prev.next = entry;
        }
    }

    private int hash(T key){
        return Math.abs(key.hashCode())%capacity;
    }

    public void remove(T key){
        int pos = hash(key);
        if(arr[pos] == null) throw new NoSuchElementException("no such element ");
        Entry head = arr[pos];
        if(head.key == key){
            arr[pos] = null;
            return;
        }
        while(head.next != null && head.next.key != key){
            head = head.next;
        }
        if(head.next == null) throw new NoSuchElementException("no such element");
        else head.next = head.next.next;
    }

    public K get(T key){
        int pos = hash(key);
        if(arr[pos] == null) throw new NoSuchElementException("no such element");
        Entry<T, K> head = arr[pos];
        while(head != null && head.key != key){
            head = head.next;
        }
        if(head == null) throw new NoSuchElementException("no such element");
        return head.value;
    }


    public class Entry<T, K>{
        T key;
        K value;
        Entry next;

        public Entry(T key, K value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }


}