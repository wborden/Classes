package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    
    
    public static void main(String[] args) throws FileNotFoundException {
	
	
	Scanner in = new Scanner(new File("input_100.txt"));
	
	
	
	ArrayList<Integer> lst = new ArrayList<Integer>();
	
	while(in.hasNext()) {
		
		lst.add(in.nextInt());
		
	}
	
	in.close();
	
	
	int[] arr = new int[lst.size()];
	int[] temp = new int[lst.size()];
	
	for (int i = 0; i < arr.length -1 ; i++) {
	    
	    
	    arr[i] = lst.get(i);
	    temp[i] = lst.get(i);
	    
	}
	
	
	
	
	
    
    }
    
    
    
    
}
