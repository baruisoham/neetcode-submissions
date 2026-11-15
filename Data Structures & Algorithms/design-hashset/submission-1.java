class MyHashSet {


    boolean[] status;
    public MyHashSet() {
        status = new boolean[1000001];
    }
    
    public void add(int key) {
        status[key] = true;
    }
    
    public void remove(int key) {
        status[key]=false;
    }
    
    public boolean contains(int key) {
        return status[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */