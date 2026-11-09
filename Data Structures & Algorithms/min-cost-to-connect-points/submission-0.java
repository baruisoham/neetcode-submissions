class Solution {

    public int minCostConnectPoints(int[][] points) {

        Queue<Integer> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[points.length];

        queue.add(0);
        int totalDist = 0;
        final PriorityQueue<int[]> distPq = new PriorityQueue<>((a,b) ->
                a[0]-b[0]
            );

        distPq.add(new int[]{0,0});
        
        while(!distPq.isEmpty()){

            int[] nextNode = distPq.poll();

            if(nextNode==null) break;
            int currptIdx = nextNode[1];
            if(visited[currptIdx]) continue;
                totalDist += nextNode[0];


            int[] currpt = points[currptIdx];
            
            visited[currptIdx] = true;

            for(int i=0; i<points.length; i++){
                if(visited[i]) continue;

                final int[] nextpt = points[i];

                int dist = Math.abs(currpt[0] - nextpt[0]) + Math.abs(currpt[1] - nextpt[1]);
                distPq.offer(new int[]{dist, i});
            }

            
            

        }
        return totalDist;
        
    }
}
