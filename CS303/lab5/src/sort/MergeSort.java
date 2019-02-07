package sort;

public class MergeSort {
    
    
    
   public static void mergeSort(int[] A, int[] temp, int p, int r) {
       
       if(p < r) {
	   
	   
	   int q = (p + r)/2;
	   
	   mergeSort(A, temp, p, q);
	   mergeSort(A, temp, q +1, r);
	   merge(A, temp, p, q, r);
	   
       }
       
       
   }
   
   
   
   public static void merge(int[] A, int[] temp, int p, int q, int r) {
	
	int i = p; 
	int j = q + 1;
	
	for(int k = p; k <= r; k++) {
		
		temp[k] = A[k];
		
	}
	
	for(int k = p; k <= r; k++) {	
	
	
	if(i > q) {	
			
		A[k] = temp[j];
		
			j = j +1;		
	}
	
	else if(j > r) {		
		
		A[k] = temp[i];
				
				i = i + 1;
		
	}
	
	else if(temp[j] < temp[i]) {
	    
		A[k] = temp[j];
		
		j = j+1;		
	}	
	
	else { 
		
		A[k] = temp[i];
		
		i = i+1;
	     }
	
	
	
	}
	
	
   }
    
    
    

}
