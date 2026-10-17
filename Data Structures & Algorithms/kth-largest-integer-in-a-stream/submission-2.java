class KthLargest {

    
    private final PriorityQueue<Integer> minHeap;
    private final int k; 

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {

        minHeap.add(val);
        

        if (minHeap.size() > k) {   
            minHeap.poll(); 
        }

        // if we blindly keep adding and at the end we want to check the kth largest, then we will have to keep poll() k times, which will remove elements so we can reach kth largest element, then when next add() happens, we have lost the original elements. So we will have to re add the ones we removed.
        // Instead, we always have to track the kth largest, so when k elemnts are filled, the poll() value is the kth largest element, we can remove if the pq becomes more than k, as the rest are not required, we only need till kth largest.

        return minHeap.peek();
    }
}
