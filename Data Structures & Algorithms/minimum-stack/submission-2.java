class MinStack {

    private Node tail;
    private int size = 0;

    public MinStack() {

    }
    
    public void push(int val) {
        Node newNode;
        if(size==0){
            newNode = new Node(val, null, val);
        } else{
            newNode = new Node(val, tail, Math.min(tail.minNode, val));
            newNode.prev.next = newNode;
        }
        size++;
        tail = newNode;
        
    }
    
    public void pop() {
        tail = tail.prev;
        size--;
    
        if(size>0) tail.next=null;
        
    }
    
    public int top() {
        return tail.value;
    }
    
    public int getMin() {
        return tail.minNode;
    }


    private class Node{
        public int value;
        public Node prev;
        public Node next;
        public int minNode;

        public Node(int value, Node prev, int minNode){
            this.value = value;
            this.prev = prev;
            this.minNode = minNode;
        }

        public int getValue(){
            return this.value;
        }

        public Node getPrev(){
            return this.prev;
        }
    }
}
