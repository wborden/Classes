package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import sort.*;


public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		Scanner in = new Scanner(new File("input_5000000.txt"));
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		while(in.hasNext()) {
			
			lst.add(in.nextInt());				
		}		
		
		in.close();
	
		
		
		//System.out.println(lst.toString());
		
		int[] arrHeap = new int[lst.size()];
		int[] arrInsert = new int[lst.size()];
		int[] arrMerge = new int[lst.size()];
		int[] arrMergeTemp = new int[lst.size()];
		
		for(int i = 0; i < lst.size(); i++) {
			
		    arrHeap[i] = lst.get(i);
		    arrInsert[i] = lst.get(i);
		    
		    arrMerge[i] = lst.get(i);
		    arrMergeTemp[i] = lst.get(i);
			
		}
		
		long heapSortStart = System.nanoTime();
		
		HeapSort.heapSort(arrHeap);
	
		double endHeapTime = (System.nanoTime() - heapSortStart) * (1.0 / 1000000.0);
		
		System.out.println("Heapsort time was: " + endHeapTime);
	
		
		
		
		int p = 0;
		int r = lst.size() - 1;
		
		long mergeSortStart = System.nanoTime();
		
		MergeSort.mergeSort(arrMerge, arrMergeTemp, p, r);
	
		double endMergeTime = (System.nanoTime() - mergeSortStart) * (1.0 / 1000000.0);	
		
		
		System.out.println("Mergesort time was: " + endMergeTime);
		
		
		
		long insertSortStart = System.nanoTime();
		
		InsertSort.Insertion(arrInsert);
	
		double endInsertTime = (System.nanoTime() - insertSortStart) * (1.0 / 1000000.0);
		
		System.out.println("Insertsort time was: " + endInsertTime);
		
		
	
	ArrayList<Integer> res = new ArrayList<Integer>();
	
	for(int i = 0; i < arrHeap.length; i++) {
		
		res.add(arrHeap[i]);
		
	}
	
	
	System.out.println("Input size was: " + res.size());
	//System.out.println(res.toString());
	
	
	
	
	}
}
