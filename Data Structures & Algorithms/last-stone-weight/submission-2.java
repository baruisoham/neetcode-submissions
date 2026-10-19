class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxStones = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        for(int stone: stones){
            maxStones.offer(stone);
        }
        while(maxStones.size()>1){
            int x = maxStones.poll();
            int y = maxStones.poll();
            if(x==y) continue;
            else maxStones.offer(Math.abs(y-x));
        }
        if(!maxStones.isEmpty()) result = maxStones.poll();
        return result;
    }
}
