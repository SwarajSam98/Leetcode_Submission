class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;

        // Step 1: Build prefix sums in-place (reuse grid to save memory)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Value from above cell (if exists)
                int top = (i > 0) ? grid[i-1][j] : 0;

                // Value from left cell (if exists)
                int left = (j > 0) ? grid[i][j-1] : 0;

                // Value from diagonal cell (to remove double counting)
                int diag = (i > 0 && j > 0) ? grid[i-1][j-1] : 0;

                // Update current cell to store prefix sum
                grid[i][j] = grid[i][j] + top + left - diag;
            }
        }

        // Step 2: Count how many submatrices have sum ≤ k
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Since grid[i][j] now contains prefix sum, just check it
                if (grid[i][j] <= k) {
                    count++;
                }
            }
        }

        return count; 
    }
}