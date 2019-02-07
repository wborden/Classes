package sort;

public class QuickSort {

	
	public static void quickSort(int[] A, int p, int r) {
		
		
		if(p < r) {
			
			int q = partition(A, p, r);
			
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
			
		}
		
		
		
	}
	
	
	public static int partition(int[] A, int p, int r) {
		
		int x = A[r]; 
		int i = p-1;
		
		for(int j = p; j <= r -1; j++) {
			
			
			if(A[j] < x) {
				
				i = i + 1;
				int temp = A[i];
				
				A[i] = A[j];
				
				A[j] = temp;
				
			}
			
			
			
		}
		
		
		
		int temp2 = A[i + 1];
		A[i + 1] = A[r];	
		A[r] = temp2;
		
		
		
		
		return i + 1;
		
		}
	
	
		

	public static void med3QuickSort(int[] A, int p, int r, int cutoff) {
	    
	    int n = p - r + 1;
	    
	    if(n < cutoff) {
		
		InsertSort.Insertion(A);
				
		return;
	    }
	    
	    int m = median3(A, p, p + (n/2), r);
	    
	    int temp = A[m];
	    
	    A[m] = A[p];
	    
	    A[p] = temp;
	    
	    
	   int q = partition(A, p, r);
	    
	    med3QuickSort(A, p, q-1, cutoff);
	    med3QuickSort(A, q + 1, r, cutoff);
	}
	
	
	
	public static int median3(int[] A, int i, int j, int k) {
	    
	    
	    int median = A[i];
	    
	    if(A[i] < A[j] && A[j] < A[k]) {
		
		median = j;
	    }
	    
	    else if(A[i] < A[k] && A[k] < A[j]) {
		
		median = k;
	    }
	    
	    
	    return median;
	    
	}
	
	
		
		
	
	
	
	
}
