package sort;

public class InsertSort {
	
	
	
	
	public static int[] Insertion(int[] a) {
		
		
		
		
		for(int j = 1; j < a.length; j++) {
			
			
			int key = a[j];
			int i = j - 1;
			
			
			while( i >= 0 && a[i] > key) {
				
				a[i + 1] = a[i];
				
				i = i - 1;
				
				a[i+1] = key;
			}
			
			
			
			
		}
		
		return a;
		
		
		
		
	}

}
