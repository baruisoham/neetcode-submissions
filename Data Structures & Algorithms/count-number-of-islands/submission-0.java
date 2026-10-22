class Solution {

    private int totalR=0;
    private int totalC=0;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        int result = 0;
        totalR = grid.length;
        totalC = grid[0].length;
        if(totalC==0 && totalR==0) return 0;
        this.grid = grid;
        for(int i=0; i<totalR; i++){
            for(int j=0; j<totalC; j++){
                if(grid[i][j]=='1') result++; 
                dfs(i, j);
            }
        }
        return result;
    }

    private void dfs(int r, int c){
        if(r>(totalR-1) || 0>r || c>(totalC-1) || 0>c || grid[r][c]=='0') return;
        this.grid[r][c]='0';
        dfs(r+1, c);
        dfs(r, c+1);
        dfs(r-1, c);
        dfs(r, c-1);
    }
}
