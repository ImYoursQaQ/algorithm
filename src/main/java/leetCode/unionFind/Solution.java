package leetCode.unionFind;

/**
 * 200. 岛屿数量
 * 解法1dfs，解法2 并查集
 */
class Solution {
    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        int[] x = new int[]{0, 0, -1, +1};
        int[] y = new int[]{-1, +1, 0, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    markDFS(grid, i + x[0], j + y[0], m, n);
                    markDFS(grid, i + x[1], j + y[1], m, n);
                    markDFS(grid, i + x[2], j + y[2], m, n);
                    markDFS(grid, i + x[3], j + y[3], m, n);
                    count++;
                }
            }

        }
        return count;
    }

    private static void markDFS(char[][] grid, int i, int j, int m, int n) {
        int[] x = new int[]{0, 0, -1, +1};
        int[] y = new int[]{-1, +1, 0, 0};
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (grid[i][j] == '1') {
                grid[i][j] = 0;
                markDFS(grid, i, j + 1, m, n);
                markDFS(grid, i, j - 1, m, n);
                markDFS(grid, i + 1, j, m, n);
                markDFS(grid, i - 1, j, m, n);
            }
        }

    }

    public static void main(String[] args) {
        int x = 15;
        System.out.println(x & -x);

    }
}