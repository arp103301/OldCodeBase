package ik.com.anup.graphs;

//https://www.youtube.com/watch?v=umcgWkAR2Dc
//https://www.youtube.com/watch?v=U6-X_QOwPcs&t=1s

import java.util.ArrayList;
import java.util.Stack;

/*Given a two-dimensional grid of 0s and 1s, find the size of the largest island. If there is no island return 0.

An island is a group of 1s connected vertically or horizontally.

Example One
{
"grid": [
[1, 1, 0],
[1, 1, 0],
[0, 0, 1]
]
}
Output:

4
There are two islands:

[(0, 0), (0, 1), (1, 0), (1, 1)]
[(2, 2)]
Size of the largest (first) island is 4.

Example Two
{
"grid": [
[0, 0, 0],
[0, 0, 0],
[0, 0, 0]
]
}
Output:

0
Notes
Constraints:

1 <= number of rows <= 200
1 <= number of columns <= 200*/


class FindLargestIsland {

    // TC : O(n*m)
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                	count++;
                    maxArea = Math.max(maxArea, dfs(i,j, grid));
                }
            }
        }
        return maxArea;
       // return count;
    }



    private int dfs(int i,int j, int[][] grid){
    	if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        // grid[i][j] = 1
        grid[i][j]=-1;
        int leftArea = dfs(i,j-1, grid);
        int rightArea = dfs(i,j+1, grid);
        int upArea = dfs(i-1,j, grid);
        int downArea = dfs(i+1,j, grid);

        int totalArea = 1 + leftArea + rightArea +upArea+downArea;

        return  totalArea;

    }
}



















/*
 * public class FindLargestIsland { static Integer
 * max_island_size(ArrayList<ArrayList<Integer>> grid) {
 * 
 * Integer max = 0; int numRow = grid.size(); int numCol = grid.get(0).size();
 * 
 * for (int row = 0; row < numRow; row++) { for (int col = 0; col < numCol;
 * col++) { int count = 0; if (grid.get(row).get(col) == 1) { Stack<Coordinates>
 * stack = new Stack<Coordinates>(); stack.push(new Coordinates(row, col));
 * grid.get(row).set(col, 2); while (!stack.isEmpty()) {
 * 
 * Coordinates coord = stack.pop();
 * 
 * count++; // i-1, j if (coord.row - 1 >= 0 && grid.get(coord.row -
 * 1).get(coord.col) == 1) { grid.get(coord.row - 1).set(coord.col, 2);
 * stack.push(new Coordinates(coord.row - 1, coord.col)); } // i, j+1 if
 * (coord.col + 1 < grid.get(coord.row).size() &&
 * grid.get(coord.row).get(coord.col + 1) == 1) {
 * grid.get(coord.row).set(coord.col + 1, 2); stack.push(new
 * Coordinates(coord.row, coord.col + 1)); } // i+1, j if (coord.row + 1 <
 * grid.size() && grid.get(coord.row + 1).get(coord.col) == 1) {
 * grid.get(coord.row + 1).set(coord.col, 2); stack.push(new
 * Coordinates(coord.row + 1, coord.col)); } // i, j-1 if (coord.col - 1 >= 0 &&
 * grid.get(coord.row).get(coord.col - 1) == 1) {
 * grid.get(coord.row).set(coord.col - 1, 2); stack.push(new
 * Coordinates(coord.row, coord.col - 1));
 * 
 * } } if (max < count) max = count;
 * 
 * } } } return max; }
 * 
 * static class Coordinates { int row; int col; Coordinates (int i, int j) {
 * this.row = i; this.col = j; } } }
 * 
 * 
 * public class FindLargestIsland2 {
 * 
 * public int maxAreaOfIsland(int[][] grid) { boolean[][] seen = new
 * boolean[grid.length][grid[0].length]; int[] dr = new int[]{1, -1, 0, 0};
 * int[] dc = new int[]{0, 0, 1, -1};
 * 
 * int result = 0; for (int r0 = 0; r0 < grid.length; r0++) { for (int c0 = 0;
 * c0 < grid[0].length; c0++) { if (grid[r0][c0] == 1 && !seen[r0][c0]) { int
 * shape = 0; Stack<int[]> stack = new Stack(); stack.push(new int[]{r0, c0});
 * seen[r0][c0] = true; while (!stack.empty()) { int[] node = stack.pop(); int r
 * = node[0], c = node[1]; shape++; for (int k = 0; k < 4; k++) { int nr = r +
 * dr[k]; int nc = c + dc[k]; if (0 <= nr && nr < grid.length && 0 <= nc && nc <
 * grid[0].length && grid[nr][nc] == 1 && !seen[nr][nc]) { stack.push(new
 * int[]{nr, nc}); seen[nr][nc] = true; } } } result = Math.max(result, shape);
 * } } } return result; }
 * 
 * }
 * 
 */





/*dfs_solution.cpp
The idea is to traverse the grid and whenever we get a 1, we start a DFS from that cell and mark the cells connected to it. 
We keep the count of marked cells during each DFS and the maximum count so far. Thus we traverse each island and
 find the island of maximum size.

During DFS while traversing the cells we need to check whether to visit it or not. We will not visit a cell 
if either of the following holds:

The cell coordinate exceeds array dimensions.
The cell is already visited.
The cell value is 0, thus not a part of any island.
Otherwise, we will visit the cell and do the following:

Increment our counter. This counter will hold the current size of the island.
Mark the cell as visited.
Traverse the cells adjacent to it vertically or horizontally.
Time Complexity
O(R * C).
We traverse all cells in the grid, so time complexity is O(R * C).

Auxiliary Space Used
O(R * C).
For DFS we need a two-dimensional array to keep track of the visited cells. Also, during DFS the function call stack can lead to O(R * C) calls. This leads to the memory requirement of O(R * C).

Space Complexity
O(R * C).
Space used for input: O(R * C).
Auxiliary Space used: O(R * C).
Space used for output: O(1).
So, total space complexity: O(R * C).

bfs_solution.cpp
*/