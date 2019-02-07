package driver;

import graph.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver{
	
	
	public static void main(String[] args) throws IOException {
		
	
	
	
	
	
	try {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("tinyDG.txt")));
		UndirectedGraph graph = new UndirectedGraph(reader);
		String dGraph =  graph.tostring();
				System.out.println(dGraph);
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
	Vertex s = new Vertex();
	s = (Vertex) graph.adj;
	BFS(graph, graph.adj[0]);
	
	}
	
	
}
