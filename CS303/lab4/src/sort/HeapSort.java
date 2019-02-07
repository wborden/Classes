package sort;

public class HeapSort {
	
	
	public static int heapSize;
	public static int largest;
	
	
	public static void heapSort(int[] A) {
		
		buildMaxHeap(A);
		
		for(int i = A.length - 1; i >= 0; i--) {
			
			int temp = A[0];
			
			A[0] = A[i];
			
			A[i] = temp;			
						
			heapSize = heapSize - 1;
			
			maxHeapify(A, 0);		
			
		}
		
	}
	
	
	
	
	
	private static void maxHeapify(int[] A, int i) {
		
		 
		
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		
		if(l <= heapSize && A[l] > A[i]) {
			
			 largest = l;
			
		}
		
		else { largest = i; }
		
		if(r <= heapSize && A[r] > A[largest])  {
			
			largest = r;
			
		}
		
		if(largest != i) {
			
			int temp = A[i];
			
			A[i] = A[largest];
			
			A[largest] = temp;
			
			maxHeapify(A, largest);
		}
		
	}



	public static void buildMaxHeap(int[] A) {
		
		heapSize = A.length-1;
		
		for(int i = (A.length/2); i >= 0; i--) {
			
			maxHeapify(A, i);
			
		}
		
	}
	
	
	
	

}
