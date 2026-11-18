class Solution {
    public int orangesRotting(int[][] grid) {
        int rotten = 0;
        int fresh = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) {
                    rotten++;
                    queue.add(new int[]{i,j});
                }
            }
        }

        int time = 0;
        if(fresh==0) return 0;
        

        while(!queue.isEmpty()){
            time++;
            int levelSize = queue.size();

            for(int n = 0; n<levelSize; n++){


                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                if(grid[i][j]==-1) continue;

                if(grid[i][j]==1 || grid[i][j]==2){
                    if(grid[i][j]==1) fresh--;
                    grid[i][j]=-1;
                    addToQueue(i-1,j, grid, queue);
                    addToQueue(i+1,j, grid, queue);
                    addToQueue(i,j+1, grid, queue);
                    addToQueue(i,j-1, grid, queue);
                }

            }
            if (fresh==0) return time-1;

        }
        return -1;

    }

    private void addToQueue(int i, int j, int[][] grid, Queue<int[]> queue){
        if(0<=i && i<grid.length && 0<=j && j<grid[0].length && grid[i][j]!=0 && grid[i][j]!=-1) queue.add(new int[]{i,j});
    }
}
