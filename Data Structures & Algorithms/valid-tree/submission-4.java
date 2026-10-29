class Solution {
    public boolean validTree(int n, int[][] edges) {


        final HashMap<Integer, List<Integer>> adjMat = new HashMap<>();

        for(int[] edge: edges){
            makeEntry(edge[0], edge[1], adjMat);
        }

        if(edges.length==0) return true;

            final boolean[] visited = new boolean[n];
        
            if(isCyclic(0, 0, adjMat, visited)) return false;
            for(boolean isVisited: visited){
                if(!isVisited) return false;
            }
        return true;
    }


    private void makeEntry(int i, int j, HashMap<Integer, List<Integer>> adjMat){
        adjMat.computeIfAbsent(i, (k) -> new ArrayList<Integer>()).add(j);
        adjMat.computeIfAbsent(j, (k) -> new ArrayList<Integer>()).add(i);
    }

    private boolean isCyclic(int prev, int curr, HashMap<Integer, List<Integer>> adjMat, boolean[] visited){
        if(visited[curr]) return true;
        visited[curr]=true;

        for(int next: adjMat.get(curr)){
            if(next!=prev && isCyclic(curr, next, adjMat, visited)) return true;
        }
        return false;
    }
}
