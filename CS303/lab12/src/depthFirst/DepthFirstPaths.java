package depthFirst;

import java.util.Stack;

import graph.*;

public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    /**
     * Computes a path between <tt>s</tt> and every other vertex in graph <tt>G</tt>.
     * @param G the graph you built in the previous assignment, make sure it has the adjacency list adj for each vertex
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
        //initialize marked, edgeTo and s
    	this.s = s;
    	marked = new boolean[G.V];
    	edgeTo = new int[G.V];
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        //write your dfs code here. Edit edgeTo and marked whenever necessary. It would be easy to use recursion in this function
    	
    	marked[v] = true;
    	
    	for(int i: G.adj[v]) {
    		
    		if(!marked[i]){
    			edgeTo[i] = v;
    			dfs(G, i);
    			
    		}
    		
    	}
    
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        
    	return marked[v];
    	
    }

    /**
     * Returns a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>, or
     * <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *   <tt>s</tt> and vertex <tt>v</tt>, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
       
    	if(hasPathTo(v) != true) return null;
    	
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    /**
     * Unit tests the <tt>DepthFirstPaths</tt> data type.
     */
    

}