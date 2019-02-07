package sort;

public class MergeSort {
    
    
    
   public static void mergeSort(int[] A, int[] temp, int p, int r) {
       
       if(p < r) {
	   
	   
	   int q = (int) Math.floor((p + r)/ 2);
	   
	   mergeSort(A, temp, p, q);
	   mergeSort(A, temp, q +1, r);
	   merge(A, temp, p, q, r);
	   
       }
       
       
   }
   
   
   
   public static void merge(int[] a, int[] temp, int p, int q, int r) {
       
       for(int i = p; i < r; i++) {
	   
	   for(int j = q + 1; j < r; j++) {
	       
	   }
	   
       }
       
       
   }
    
    
    

}
