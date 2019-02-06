package driver;

import sort.ArraySort;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File("input100.txt"));
	
		int[] arr = new int[100];
		
		for(int i = 0; i < arr.length; i++) {
			
			
			arr[i] = scanner.nextInt();
			
		}
		
		
		scanner.close();
		
		Arrays.sort(arr);
		
		int low = 0;
		int high = arr.length -1;
		int target = 83;
		
		System.out.println("Low is: " + low);
		System.out.println("High is: " + high);
		
		int res = ArraySort.binarySearch(arr, low, high, target);	
		
		
		ArraySort.linearSearch(arr, target);
		
		
		System.out.println(res);
				
		
	}

}
