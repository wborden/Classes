package driver;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import hash.HashMap;




public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		
		
		HashMap test = new HashMap();
		//test.put(1, "one");
		//test.put(2, "two");
		//test.put(3, "three");
		//test.put(4, "four");
		//test.put(103, "103");
		//S/ystem.out.println(test.get(3));
		//System.out.println(test.get(103));
		
		//test.linearProbe(42, "fourtytwo");
		
		//test.quadraticProbe(99, "DatQuad");
		//System.out.println(test.get(42));
		//System.out.println(test.get(99));
		
		
		
		
		
		File upc = new File("UPC.csv");
		    Scanner inUPC = new Scanner(upc);
			
				
		   
		    inUPC.useDelimiter(",");
		    
	    		
			while(inUPC.hasNextLine()) {
			    
			    String key = inUPC.next();
			    int keyFloat = Integer.parseInt(key);
			    String value = inUPC.next();
			  if(inUPC.hasNext()) { value = value + " " + inUPC.next();}
			  
			 test.put(keyFloat, value);
			  
			  
			 if(inUPC.hasNextLine()) {inUPC.nextLine();}
			    
			    
			    
			    System.out.println(key + " "  + value);
			   
			}
			
			inUPC.close();
			
			
			Float key = 79.0F;
			    
			    
			    
			    
			File dat = new File("input.dat");
	}
	
	
}
