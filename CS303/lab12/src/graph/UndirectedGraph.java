package graph;

import java.io.BufferedReader;
import java.io.IOException;

public class UndirectedGraph extends Graph{
	
	public UndirectedGraph() {
		
		super();
		
	}
	
	@Override
	public void addEdge(int v, int w) {
		
		
		adj[v].add(w);
		adj[w].add(v);
		
		
	}
	
	
	public UndirectedGraph(BufferedReader reader) throws IOException
    {
        super(reader);
        
    }
	
	public String tostring() {
		
		return super.tostring();
		
	}
	
	public void BFS(UndirectedGraph G, int s) {
		
		
		
	}

}
