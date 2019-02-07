package driver;

import graph.*;
import depthFirst.DepthFirstPaths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
	
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
	

		
			
			BufferedReader reader = new BufferedReader(new FileReader(new File("mediumG.txt")));
			Graph G = new Graph(reader);
			
			int s = G.getStart();

			DepthFirstPaths dfs = new DepthFirstPaths(G, s);
			
		for(int v = 0; v < G.V; v++) {
			
			if(dfs.hasPathTo(v)) {
				System.out.println("0 to " + v + " 0");
				
				for(int y : dfs.pathTo(v)) {
					
					if ( y == s) System.out.println(y);
					else System.out.println("-" + y);
				}
				System.out.println();
			}
		
			else {
				System.out.println("Not connected");
			}
		
		
		}
	
	
	}
	
	
}
