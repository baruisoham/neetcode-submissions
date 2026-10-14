class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        final PriorityQueue<FreqEntry> pq = new PriorityQueue<>((f1, f2) -> f2.count - f1.count);

        final HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            pq.offer(new FreqEntry(entry.getKey(), entry.getValue()));
        }

        final int[] result = new int[k];

        for(int i=0; !pq.isEmpty() && i<result.length; i++){
            result[i] = pq.poll().num;
        }
        return result;
    }
}


class FreqEntry{
    int num;
    int count;
    FreqEntry(int num, int count){
        this.num=num;
        this.count=count;
    }
}
