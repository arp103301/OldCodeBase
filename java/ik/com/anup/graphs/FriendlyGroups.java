package ik.com.anup.graphs;

//886. Possible Bipartition

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*There are n people living in a town. Some of them dislike each other. 
 * Given the value of n and two equal length integer arrays called dislike1 and dislike2. 
 * For each i in [0, dislike1_size - 1], the person dislike1[i] dislikes the person dislike2[i]. 
 * Check if we can divide the people of the town into two sets such that each person belongs to exactly one set 
 * and no two persons disliking each other belong to the same set.

Example One
{
"num_of_people": 5,
"dislike1": [0, 1, 1, 2, 3],
"dislike2": [2, 2, 4, 3, 4]
}
Output:

1
The people can be partitioned into two sets [0, 1, 3] and [2, 4].

Example Two
{
"num_of_people": 4,
"dislike1": [0, 0, 0, 1, 2],
"dislike2": [1, 2, 3, 2, 3]
}
Output:

0
Notes
People are numbered from 0 to n - 1.

Constraints:

1 <= n <= 2*103
0 <= number of disliking pairs <= min((n * (n - 1))/2, 104)*/
public class FriendlyGroups {


    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {
        // Write your code here.
        
        //Build a graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        int[] visited = new int[num_of_people];
        int[] color = new int[num_of_people];
        
        for(int i = 0; i < num_of_people; i++){
            adjList.add(i, new ArrayList());
            visited[i] = -1;
        }
        
        for(int i = 0; i < dislike1.size(); i++){
            adjList.get(dislike1.get(i)).add(dislike2.get(i));
            adjList.get(dislike2.get(i)).add(dislike1.get(i));
        }
    
        
        //Invoke BFS
        for(int i = 0; i < num_of_people; i++){
            if(visited[i] == -1){
                if(!bfs(i, adjList, visited, color)) return false;
            }
        }
    
        return true;
    }

    static boolean bfs(int i, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] color){
        Queue<Integer> queue = new LinkedList();
        queue.add(i);
        
        visited[i] = 1;
        color[i] = 1;
  
        
        while(!queue.isEmpty()){
                  
                int u = queue.poll();
                for(Integer v : adjList.get(u)){
                    if(visited[v] == -1){
                        queue.add(v);
                        visited[v] = 1;
                        // Coloring the un-visited adjacent node with a different color than the current node.
                        color[v] = - color[u];//************
                    } else {
                        if(color[v] % 2 == color[u] % 2) return false;
                        // if both are same color then total length will be even+1 (cross edge ) 
                        //makeing the totla length odd hence theyare not bipartite:: check the class notes
                    }
                }
        }
        
        return true;// if the traversal is completed then BFS is good
    }
}
/*
Asymptotic complexity in terms of number of people `n` and number of disliking pairs `m`:
* Time: O(n + m).
* Auxiliary space: O(n).
* Total space: O(n + m).
*/