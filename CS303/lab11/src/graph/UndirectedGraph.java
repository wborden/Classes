package graph;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

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
	
	 public void BFS(UndirectedGraph graph, Vertex s) {
	     
	    
	     LinkedList<Vertex> infoQ = new LinkedList<Vertex>();
	     
	     for(int i = 0; i <= V; i++) {
		 
		 infoQ.add(new Vertex(graph.adj[i]));		 
		 Vertex cur = infoQ.get(i);
		 cur.setColor(Color.WHITE);
		 cur.setDistance(Integer.MAX_VALUE);
		 cur.setParent(null);
		 
		 
	     }
	     
	     s.setColor(Color.GRAY);
	     s.setDistance(0);
	     s.setParent(null);
		
	     
	     
	     infoQ.add(s);
		
	     while(!infoQ.isEmpty()) {
		 
		 Vertex u = infoQ.remove();
		 
		 for(int i = 0; i <= infoQ.size(); i++) {
		     
		     if(infoQ.get(i).getColor() == Color.WHITE) {
			 
			 Vertex v = new Vertex();
			 v.setColor(Color.GRAY);
			 v.setDistance(u.getDistance() + 1);		
			 v.setParent(u);
			 infoQ.add(v);
		     }
		     
		 }
		 
		 u.setColor(Color.BLACK);
		 
	     }
	     
	     
	     
	    }

}
