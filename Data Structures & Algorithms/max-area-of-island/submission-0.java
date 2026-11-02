

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c, rows, cols));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int startR, int startC, int rows, int cols) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC});
        grid[startR][startC] = 0; // Mark visited immediately upon enqueuing

        int area = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            area++;

            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Validate bounds and check if land
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0; // Mark visited right away
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}