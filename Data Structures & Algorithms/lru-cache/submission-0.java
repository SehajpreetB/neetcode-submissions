class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) { this.key = key; this.val = val; }
    }

    private final HashMap<Integer, Node> cache = new HashMap<>();
    private final int capacity;
    private final Node head = new Node(0, 0);  // dummy: most recent is head.next
    private final Node tail = new Node(0, 0);  // dummy: least recent is tail.prev

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addToFront(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) return -1;
        remove(n);
        addToFront(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n != null) {
            n.val = value;
            remove(n);
            addToFront(n);
        } else {
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            n = new Node(key, value);
            cache.put(key, n);
            addToFront(n);
        }
    }
}
