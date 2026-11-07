class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        final int[] nodeTimes = new int[n+1];
        Arrays.fill(nodeTimes, Integer.MAX_VALUE);

        final List<List<int[]>> adjMat = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            adjMat.add(new ArrayList<>());
        }
        for(int[] time: times){
            adjMat.get(time[0]).add(new int[]{time[1], time[2]});
        }
        final int time = bfs(adjMat, k, nodeTimes);
        for(int i=1; i<nodeTimes.length; i++){
            if(nodeTimes[i]==Integer.MAX_VALUE) return -1;
        }
        return time;
    }


    private int bfs(List<List<int[]>> adjMat, int k, int[] nodeTimes){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
        {
            return a[0]-b[0];
        });


        pq.offer(new int[]{0, k});
        int minTime = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            int[] distNode = pq.poll();
            if(distNode[0] < nodeTimes[distNode[1]]){
                nodeTimes[distNode[1]] = distNode[0];
                minTime = Math.max(minTime, nodeTimes[distNode[1]]);
                for(int[] adjNode : adjMat.get(distNode[1])){
                    if(nodeTimes[adjNode[0]]>distNode[0]+adjNode[1]) pq.offer(new int[]{ distNode[0]+adjNode[1], adjNode[0]});   
                }
            }
        }
        return minTime; 
    }
}
