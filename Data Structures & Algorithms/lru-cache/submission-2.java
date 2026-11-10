class LRUCache {

    private final Map<Integer, Node> cacheMap;

    private int maxCapacity;

    private int currCapacity;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        this.maxCapacity = capacity;
        this.currCapacity=0;
    }
    
    public int get(int key) {
        Node accessNode = cacheMap.get(key);
        if(accessNode==null) return -1;
        remove(accessNode);
        insertAtHead(accessNode);
        return accessNode.val;
    }
    
    public void put(int key, int value) {
        Node accessNode = cacheMap.get(key);
        if(accessNode==null){
            if(maxCapacity==currCapacity){
                cacheMap.remove(tail.key);
                remove(tail);
            }
            else currCapacity++;
            accessNode = new Node(value, key, null);
            insertAtHead(accessNode);
        }
        else{
            remove(accessNode);
            insertAtHead(accessNode);
            accessNode.val=value;
        }
        cacheMap.put(key, accessNode);
    }


    private void insertAtHead(Node node){
        node.next = head;
        if(head!=null){
            node.prev = head.prev;
            head.prev = node;
        }
        else tail = node;
        head = node;
    }

    private void remove(Node node){
        if (node==head) head = head.next;
        if(node==tail) tail = tail.prev;

        if(node.prev!=null) node.prev.next = node.next;
        if(node.next!=null) node.next.prev = node.prev;

        node.prev=null;
        node.next=null;
    }

    private class Node{

        public int val;
        public int key;
        public Node prev;
        public Node next;

        public Node(int val, int key, Node prev){
            this.val = val;
            this.key = key;
        }

        

    }
    
}
