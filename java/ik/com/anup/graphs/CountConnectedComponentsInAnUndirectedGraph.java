package ik.com.anup.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given an undirected graph with edges given, find its total number of connected components.

Example One
Graph

{
"n": 5,
"edges": [[0 ,1], [1, 2], [0, 2], [3, 4]]
}
Output:

2
Example Two
Graph

{
"n": 4,
"edges": [[0 , 1], [0 , 3], [0 , 2], [2 , 1], [2 , 3]]
}
Output:

1
Notes
Constraints:

1 <= number of nodes <= 105
0 <= number of edges <= 105
0 <= node value < number of nodes*/
public class CountConnectedComponentsInAnUndirectedGraph {
	static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>(n);
       
        for(int i=0;i<n ;i++){
            adjlist.add(i , new ArrayList());
        }
        
        for(ArrayList<Integer> edge : edges){
            adjlist.get(edge.get(0)).add(edge.get(1));
            adjlist.get(edge.get(1)).add(edge.get(0));
        }
        
    /*    // Creating adjacency list representation
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>(n); 
        for(int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj_list[u].push_back(v);
            adj_list[v].push_back(u);
        }
  */      
        int components =0;
        int[] visited = new int[n];
         
        for(int i=0;i< n;i++){// for loop for number of nodes given in question
            if(visited[i]==0){
            	
				/*
				 * The number of connected components in the graph is is equal to the
				 * number of BFS rounds performed.
				 */
               components++;
               bfs(i,adjlist,visited);
            }
        }
        return components;
    }
    static void bfs(Integer src,ArrayList<ArrayList<Integer>> adjlist,int[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(src.intValue());// int --> Integer
        visited[src]=1;///
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer neighbor : adjlist.get(node)){
                if(visited[neighbor]==0){
                 visited[neighbor]=1;
                 q.offer(neighbor);
                }
            }
        }
    }

}
