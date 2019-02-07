package graph;

import java.awt.Color;
import java.util.LinkedList;

public class Vertex {
    
	private String name;
	private int index;
   
	public Vertex(String n, int i) {
		
		this.index = i;
		this.name = n;
		
	}
	
	public Vertex(int i) {
		
		
	}
	public Vertex(String name) {
		
	
		
		this.name = name;
		
	}
	
	public void setIndex(int ind) {
		
		this.index = ind;
		
	}
	
	public int getIndex() {
		
		return index;
		
	}
	
}
