class Solution {
    public boolean isBipartite(int[][] graph) {
        

        int group = 0;

        int[] nodeStatus = new int[graph.length];
        Arrays.fill(nodeStatus, -1);

        for(int i = 0 ; i<graph.length; i++){
            if(!bfs(i, nodeStatus, graph)) return false;
        }
        return true;
    }

        


    private boolean bfs(int rootNode, int[] nodeStatus, int[][] graph){
        Queue<Integer> queue = new ArrayDeque<>();
        if(nodeStatus[rootNode]==-1) queue.add(rootNode);
        int group=0;
        while(!queue.isEmpty()){
            
            int level = queue.size();
            group = group==0 ? 1 : 0;
            for(int i = 0; i<level; i++){
                int node = queue.poll();

                for(int nbr: graph[node]){
                    if(nodeStatus[nbr]==group) return false;
                    if(nodeStatus[nbr]==-1) queue.offer(nbr);
                }
                nodeStatus[node]=group;
            }
        }
        return true;
    }
    
}
