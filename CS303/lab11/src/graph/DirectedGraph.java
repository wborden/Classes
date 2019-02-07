package graph;

import java.io.BufferedReader;
import java.io.IOException;

public class DirectedGraph extends Graph{

	
	
	public DirectedGraph() {
		
		super();
		
	}
	
	@Override
	public void addEdge(int v, int w) {
		
		adj[v].add(w);
	
		
		
	}
	
	
	public DirectedGraph(BufferedReader reader) throws IOException
    {
       super(reader);
    }
	
	public String tostring() {
		
		
		return super.tostring();
		
		
	}
	
	public int getStart() {
    	
    	return super.getStart();   	
    }
	
	
}
