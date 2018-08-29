class LRUCache {
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    ListNode head;
    int cap;
    int curSize;

    public LRUCache(int capacity) {
        head = null;
        cap = capacity;
        curSize = 0;
    }
    
    public int get(int key) {
        ListNode p = head, q = null;
        while(p != null && p.key != key){
            q = p;
            p = p.next;
        }
        
        if(p == null){
            return -1;
        }
        
        if(q ==null) return head.val;
        
        q.next = p.next;
        p.next = head;
        head = p;
        return head.val;
    }
    
    public void put(int key, int value) {
        ListNode p = head, q = null;
        while(p != null && p.key != key){
            q = p;
            p = p.next;
        }
        
        if(p == null){
            ListNode temp = new ListNode(key, value);
            temp.next = head;
            head = temp;
            curSize++;
        }else{
            if(q != null){
                q.next = p.next;
                p.next = head;
                head = p;
            }
            head.val = value;
        }
        
        if(curSize > cap){
            p = head;
            if(curSize == 2) p.next = null;
            else{
                while(p.next.next != null){
                    p = p.next;
                }
                p.next = null;
            }
            curSize--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache {
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        }
    
    ListNode head;
    ListNode tail;
    int cap;
    int curSize;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            moveNode(map.get(key));
            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            map.put(key, node);
            if(curSize == cap){
                deleteNode(tail.prev);
            }else curSize++;
        }else{
            ListNode node = map.get(key);
            node.val = value;
            moveNode(node);
        }
    }

    void moveNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    void deleteNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }
}
