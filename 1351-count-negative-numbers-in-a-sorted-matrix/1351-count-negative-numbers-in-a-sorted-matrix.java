class Solution {
    public int countNegatives(int[][] grid) {

        int totalRows = grid.length;
        int totalCols = grid[0].length;

        int row = 0, cols = totalCols - 1, count = 0;

        while (row < totalRows && cols >= 0) {
            if (grid[row][cols] < 0) {
                count = count + (totalRows - row);
                cols--;
            } else {
                row++;
            }
        }

        return count;
    }
}
