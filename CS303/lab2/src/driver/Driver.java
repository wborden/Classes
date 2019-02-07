package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sort.InsertSort;
import timer.Timer;

public class Driver {
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("input_5000000.txt"));
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		while(in.hasNext()) {
			
			lst.add(in.nextInt());
			
		}
		
		in.close();
		
		int[] arr = new int[lst.size()];
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = lst.get(i);
			
		}
		
		Timer timer = new Timer();
		
		InsertSort.Insertion(arr);
		
		double t = timer.getTime();
		System.out.println("Sort time was: " + t);
		
		
	}	
	
	

}
