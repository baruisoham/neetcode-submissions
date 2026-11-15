class MyHashSet {


    List<Integer> entries;
    public MyHashSet() {
        entries = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(!contains(key)) entries.add(key);
    }
    
    public void remove(int key) {
        entries.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return entries.contains(Integer.valueOf(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */