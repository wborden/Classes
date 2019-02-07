package graph;

import java.awt.Color;

public class VertInfo {
    
    
    private Color color;
    private int d;
    private Vertex pi;
    
    
    public VertInfo() {
	
	color = Color.WHITE;
	d = Integer.MAX_VALUE;
	pi = null;
	
	
    }
    
    
    public void setColor(Color col) {
	
	color = col;
	
    }
    
    public Color getColor() {
	
	return this.color;
	
    }
    
    public void setParent(Vertex vert) {
	
	this.pi = vert;
	
    }
    
    public Vertex getParent() {
	
	return pi;
	
    }
    
    public void setDistance(int dist) {
	
	d = dist;
	
    }
    
    public int getDistance() {
	
	return this.d;
	
    }
   

}

