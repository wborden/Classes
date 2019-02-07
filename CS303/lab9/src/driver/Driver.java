package driver;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import redblack.RBNode;
import redblack.RBTree;



public class Driver {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	
	    File upc = new File("UPC.csv");
	    Scanner inUPC = new Scanner(upc);
		
			
	    RBNode<Float, String> node = new RBNode<Float,String>(1F, null);
	    RBTree<Float, String> RbT = new RBTree<Float,String>(node);
	    
	    		inUPC.useDelimiter(",");
	    
	    		
			while(inUPC.hasNextLine()) {
			    
			    String key = inUPC.next();
			    Float keyLong = Float.parseFloat(key);
			    String value = inUPC.next();
			  if(inUPC.hasNext()) { value = value + " " + inUPC.next();}
			  
			  RbT.rbInsert(keyLong, value);
			  
			  
			 if(inUPC.hasNextLine()) {inUPC.nextLine();}
			    
			    
			    
			    System.out.println(key + " "  + value);
			   
			}
			
			inUPC.close();
			
			
			Float key = 79.0F;
			    
			    RbT.rbDataSearch(RbT.getRoot(), key);
			    
			    
			File dat = new File("input.dat");
			
			Scanner datScan = new Scanner(dat);
			
			//while(datScan.hasNextLine()) {
			    
			 //   Float key = 79.0F;
			    
			//.rbDataSearch(RbT.getRoot(), key);
			///    
			//}
			//datScan.close();
			
			//RbT.keyValTraversal(RbT.getRoot());
			
//			RbT.rbInsert(4, 42);
//			RbT.rbInsert(5, 25);
//			RbT.rbInsert(4, 772487);
//			RbT.rbInsert(21, 42);
//			RbT.rbInsert(41, 14);
//			RbT.rbInsert(7, 99);
//			RbT.rbInsert(7743, 244);
//			
//			RbT.keyValTraversal(RbT.getRoot());
			
			
			
//	RBNode<String,Integer> nodeStr = new RBNode<String,Integer>("1st", 11);
//	RBTree<String, Integer> RbTStr = new RBTree<String,Integer>(nodeStr);
//	RbTStr.rbInsert("2nd", 22);
//	RbTStr.rbInsert("3rd", 33);
//	RbTStr.rbInsert("4th", 44);
//	RbTStr.rbInsert("5th", 55);
//	RbTStr.rbInsert("6th", 66);
//	System.out.println();
//	RbTStr.keyValTraversal(RbTStr.getRoot());
	
			
			
			
		
	}	

}
