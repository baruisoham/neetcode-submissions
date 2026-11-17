class Solution {
    private int[] parent;
    private int[] rank;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        rank = new int[isConnected.length];

        for(int i =0; i<parent.length; i++){
            parent[i] = i;
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected.length; j++){
                if(isConnected[i][j]==1) merge(i, j);
            }
        }

        int provinces = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i]==i) provinces++;
        }
        return provinces;

    }

    private void merge(int x, int y){

        int a = findParent(x);
        int b = findParent(y);
        if(a==b) return;

        int rankA = rank[a];
        int rankB = rank[b];

        if(rankA==rankB){
            parent[b] = a;
            rankA+=1;
        }
        else if(rankA<rankB){
            parent[a] = b;
        }
        else parent[b] = a;
    }

    private int findParent(int node){
        int currNode = node;
        final List<Integer> traverseList = new ArrayList<>();
        while(true){
            if(parent[currNode]==currNode) break;
            traverseList.add(currNode);
            currNode = parent[currNode];
        }
        for(int interNode: traverseList) parent[interNode] = currNode;
        return currNode;
    }


}