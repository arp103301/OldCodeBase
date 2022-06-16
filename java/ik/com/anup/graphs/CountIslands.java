package ik.com.anup.graphs;

//https://www.youtube.com/watch?v=umcgWkAR2Dc
//https://www.youtube.com/watch?v=U6-X_QOwPcs&t=1s

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import ik.com.anup.graphs.KnightTourOnAChessboard.Coordinates;

/*
 * Given a two-dimensional matrix of 0s and 1s, find the number of islands.
 * 
 * An island is a group of connected 1s or a standalone 1. A cell in the matrix
 * can be connected to up to 8 neighbors: 2 vertical, 2 horizontal and 4
 * diagonal.
 * 
 * Example { "matrix": [ [1, 1, 0, 0, 0], [0, 1, 0, 0, 1], [1, 0, 0, 1, 1], [0,
 * 0, 0, 0, 0], [1, 0, 1, 0, 1] ] } Output:
 * 
 * 5 Notes Use as little extra memory as possible.
 * 
 * Solve the problem without allocating a "visited" matrix.
 * 
 * Constraints:
 * 
 * 1 <= rows <= 450 1 <= columns <= 450
 */

/********************************************************************/
/////we are not allowed to use a visited matrix, but we can modify the 
////input matrix itself! When a node is visited, change its value from 1 to 0.
/********************************************************************/

public class CountIslands{
	// TC : O(n*m)
	public int maxAreaOfIsland(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                	count++;
                    maxArea = Math.max(maxArea, dfs(i,j, grid));
                }
            }
        }
        //return maxArea;
        return count;
    }



    private int dfs(int i,int j, char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }
      
        grid[i][j]='0';
        int leftArea = dfs(i,j-1, grid);
        int rightArea = dfs(i,j+1, grid);
        int upArea = dfs(i-1,j, grid);
        int downArea = dfs(i+1,j, grid);

        int totalArea = 1 + leftArea + rightArea +upArea+downArea;

        return  totalArea;

    }
}





















/*
 * public class CountIslands_DFS {
 * 
 * 
 * static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) { if
 * (matrix.size() == 0 || matrix == null) { return 0; }
 * 
 * int numRow = matrix.size(); int numCol = matrix.get(0).size(); int
 * numberOfIslands = 0;
 * 
 * for (int r=0; r < numRow; ++r) { for (int c=0; c<numCol; ++c) { if
 * (matrix.get(r).get(c) == 1) {// count when cell has 1 to make is bigger if
 * possible ++numberOfIslands; helper(matrix, r, c);// helper(input, row ,
 * column) } } }
 * 
 * return numberOfIslands; }
 * 
 * static void helper(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
 * 
 * matrix.get(row).set(col, 0);// setting to zero
 * 
 * // All eight moves to be traversed. // left if (row - 1 >= 0 &&
 * matrix.get(row - 1).get(col) == 1) { helper(matrix, row - 1, col); } // right
 * if (row + 1 < matrix.size() && matrix.get(row + 1).get(col) == 1) {
 * helper(matrix, row + 1, col); } // up if (col - 1 >= 0 &&
 * matrix.get(row).get(col - 1) == 1) { helper(matrix, row, col - 1); } // down
 * if (col + 1 < matrix.get(0).size() &&matrix.get(row).get(col + 1) == 1) {
 * helper(matrix, row, col + 1); } // left up if (row - 1 >= 0 && col - 1 >= 0
 * && matrix.get(row - 1).get(col - 1) == 1) { helper(matrix, row - 1, col - 1);
 * } // right up if (row + 1 < matrix.size() && col - 1 >= 0 && matrix.get(row +
 * 1).get(col - 1) == 1) { helper(matrix, row + 1, col - 1); } // left down if
 * (row - 1 >= 0 && col + 1 < matrix.get(0).size() && matrix.get(row -
 * 1).get(col + 1) == 1) { helper(matrix, row - 1, col + 1); } // right down if
 * (row + 1 < matrix.size() && col + 1 < matrix.get(0).size() &&matrix.get(row +
 * 1).get(col + 1) == 1) { helper(matrix, row + 1, col + 1); }
 * 
 * } }
 */



























/*
 * public class CountIslands_BFS {
 * 
 * // All 8 directions. Consider as pair: {add_r[i], add_r[i]}. static int
 * row_moves[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1}; static int col_moves[] =
 * new int[]{-1, -1, 0, 1, 1, 1, 0, -1}; static int maxPossibleMoves = 8;//max
 * possible moves =8
 * 
 * static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) { if
 * (matrix.size() == 0 || matrix == null) { return 0; }
 * 
 * int numRow = matrix.size(); int numCol = matrix.get(0).size(); int
 * numberOfIslands = 0;
 * 
 * for (int r=0; r < numRow; ++r) { for (int c=0; c<numCol; ++c) { // When we
 * find unvisited node, visit it and visit all the reachable nodes. if
 * (matrix.get(r).get(c) == 1) { ++numberOfIslands; bfs( r, c,matrix);//
 * helper(row,col, input) } } }
 * 
 * return numberOfIslands; }
 * 
 * static void bfs(Integer start_row, Integer start_col,
 * ArrayList<ArrayList<Integer>> matrix) {
 * 
 * //int minMoves = 0;// required to find this Queue<Coordinates> queue = new
 * LinkedList<>(); queue.add(new Coordinates(start_row, start_col));
 * 
 * //visited[start_row][start_col] = true; matrix.get(start_row).set(start_col,
 * 0);// setting to zero while (!queue.isEmpty()) { int size = queue.size(); for
 * (int i = 0; i < size; i++) {
 * 
 * Coordinates currCoord = queue.poll();
 * 
 * int row = currCoord.row;// current.getRow int col = currCoord.col; /* if (row
 * == end_row && col == end_col) { // once reached to desired cell return
 * minMoves; }
 * 
 * for (int j = 0; j < maxPossibleMoves; j++) { int newRow = row + row_moves[j];
 * int newCol = col + col_moves[j];
 * 
 * if (newRow < 0 || newRow >= matrix.size() || newCol < 0 || newCol >=
 * matrix.size() ) {// valid moves continue;// next i occurs... skips this ith
 * and next iteration continues }
 * 
 * queue.add(new Coordinates(newRow, newCol)); //visited[newRow][newCol] = true;
 * matrix.get(newRow).set(newCol, 0);//added to result } } //minMoves++;//
 * inside while but outside BFS } }
 * 
 * 
 * static class Coordinates{ int row; int col; public Coordinates(int row, int
 * col){ this.row = row; this.col=col;
 * 
 * } } }
 */
/*
 * Time Complexity O(n * m).
 * 
 * Time complexity of BFS or DFS is O(V + E), in our case it will be O(n * m + 8
 * * n * m) that is O(n * m).
 * 
 * Auxiliary Space Used O(n * m) for the DFS solution, other_solution.cpp. The
 * space is used by the call stack because the solution is recursive. If we had
 * used an iterative DFS implementation, we would use a stack and same O(n * m)
 * auxiliary space for that.
 * 
 * Consider the worst case for DFS:
 * 
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 DFS would make almost n * m
 * nested recursive calls; that takes O(n * m) space.
 * 
 * BFS solution (optimal_solution.cpp), on the other hand, uses just O(max(n,
 * m)) of auxiliary space.
 * 
 * The worst-case for BFS is similar to that of DFS, where all entries of matrix
 * are 1. Consider the worst-case scenario, at some point of time all the nodes
 * of the last row and last column will be in the queue. The queue will then
 * take O(n + m) = O(max(n, m)) space.
 * 
 * This difference in used space between the two algorithms can affect
 * performance in some real life cases.
 * 
 * Space Complexity O(n * m), due to input size and auxiliary space used.
 */