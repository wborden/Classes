package sort;



public class ArraySort {
	
	
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		
		
		
		
		if (low > high) 
		
		{
			
			System.out.println("Not found");
			return 0;
		}
		else {
			
			int mid = (low + high)/2;
		
		
			if(target == arr[mid]) {				
				
				System.out.println("Number found");
				
				return mid;
				
			}
			
			if(target < arr[mid]) {
				
				return binarySearch(arr, low, mid - 1, target);
				
			}
			
			if(target > arr[mid]) {
				
				return binarySearch(arr, mid + 1, high, target);
				
			}
			
			
			
			}
		return 0;
	
			
				
		}
	
	
	public static void linearSearch(int[] arr, int value) {
		
		
		
		for (int i = 0; i < arr.length; i++) {
			
			if (value == arr[i]) {
				
				System.out.println("Found value at position " + i);
			}
		
		}
		
		
	}
		
		
		
	
	
	
	

}
