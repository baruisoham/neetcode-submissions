class Solution {
    public boolean validTree(int n, int[][] edges) {


        HashMap<Integer, List<Integer>> adjMat = new HashMap<>();

        for(int[] edge: edges){
            makeEntry(edge[0], edge[1], adjMat);
        }

        if(edges.length==0) return true;

            boolean[] visited = new boolean[n];
        
            if(dfs(0, 0, adjMat, visited)) return false;
            for(boolean isVisited: visited){
                if(!isVisited) return false;
            }
        
        return true;


    }


    private void makeEntry(int i, int j, HashMap<Integer, List<Integer>> adjMat){

        adjMat.computeIfAbsent(i, (k) -> new ArrayList<Integer>()).add(j);
        adjMat.computeIfAbsent(j, (k) -> new ArrayList<Integer>()).add(i);

    }

    private boolean dfs(int p1, int p2, HashMap<Integer, List<Integer>> adjMat, boolean[] visited){
        if(visited[p2]) return true;
        visited[p2]=true;

        for(int p: adjMat.get(p2)){
            if(p!=p1 && dfs(p2, p, adjMat, visited)) return true;
        }
        return false;

    }
}
