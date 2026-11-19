class Solution {



    public int uniquePaths(int m, int n) {
        
        final int[][] ways = new int[m][n];
        ways[0][0] = 1;


        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(i==0 && j==0) continue;
                int fromLeft = i-1>=0 ?  ways[i-1][j] : 0;
                int fromUp = j-1>=0 ? ways[i][j-1] : 0;
                ways[i][j] = fromLeft + fromUp;
            }
        }

        return ways[m-1][n-1];


    }
}
