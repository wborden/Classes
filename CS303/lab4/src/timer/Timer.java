package timer;

public class Timer {
	
	
	
	
	public Timer() {
		
		
		 this.start = System.nanoTime();
		
	}
	
	
	public double getTime() {
		
		long stop = System.nanoTime();
		
		long time = stop - this.start;
		
		
		double milliTime = time * (1.0 / 1000000.0);
		
		return milliTime; 
	}
	
	
	
	
	
	
	public final long start;

}
