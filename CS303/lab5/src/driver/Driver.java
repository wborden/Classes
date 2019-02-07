package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sort.HeapSort;
import sort.InsertSort;
import sort.MergeSort;
import sort.QuickSort;




public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		Scanner in = new Scanner(new File("input_8192.txt"));
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		while(in.hasNext()) {
			
			lst.add(in.nextInt());			
			
		}
		in.close();
		
		System.out.println(lst.toString());
		int[] arr = new int[lst.size()];
		
		
		
		for(int i = 0; i < lst.size(); i++) {
			
			 arr[i] = lst.get(i);
		
		}
		
		
		int p = 0;
		int r = arr.length - 1;
		int cutoff = 10;
		
		long startTime = System.nanoTime();
				
		QuickSort.quickSort(arr, p, r);
		
		double endTime = (System.nanoTime() - startTime) * (1.0 / 1000000);
		
		
		long startTimeMed3 = System.nanoTime();
		
		QuickSort.med3QuickSort(arr, p, r, cutoff);
		
		double endTimeMed3 = (System.nanoTime() - startTimeMed3) * (1.0 / 1000000);
		
		
		long startTimeInsertion = System.nanoTime();
		
		InsertSort.Insertion(arr);
		
		double endTimeInsertion = (System.nanoTime() - startTimeInsertion) * (1.0 / 1000000);
		
		
		int[] temp = new int[arr.length];
		
		long startTimeMerge = System.nanoTime();
		
		MergeSort.mergeSort(arr, temp, p, r);
		
		double endTimeMerge = (System.nanoTime() - startTimeMerge) * (1.0 / 1000000);
		
		
		
		long startTimeHeap = System.nanoTime();
		
		HeapSort.heapSort(arr);
		
		double endTimeHeap = (System.nanoTime() - startTimeHeap) * (1.0 / 1000000);
		
	
		
		
		System.out.println("Sort time for normal QuickSort was: " + endTime + " milliseconds");
		System.out.println("Sort time for med3QuickSort was: " + endTimeMed3 + " milliseconds");
		System.out.println("Sort time for InsertSort was: " + endTimeInsertion + " milliseconds");
		System.out.println("Sort time for mergeSort was: " + endTimeMerge + " milliseconds");
		System.out.println("Sort time for heapSort was: " + endTimeHeap + " milliseconds");
		
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			
			res.add(arr[i]);
			
		}
		
		
		System.out.println("Input size was: " + res.size());
		
		
		System.out.println(res.toString());
		
		
	}
	
	
	

}
