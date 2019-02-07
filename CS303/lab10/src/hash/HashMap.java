package hash;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class HashMap {
  private final static int TABLE_SIZE = 100;

  HashEntry[] table;

  public HashMap() {
      
	  table = new HashEntry[TABLE_SIZE];
  }

  public String get(int key) {
	  int i = 0;
	  
	  int index = indexFromKey(key);
	  
	  while(table[index] != null && table[index].getKey() != key) {
		  
		  if(i >= 100) {
			  
			  System.out.println("Reached max table size");
			  break;
		  }
		  i++;
		  index = (7 * indexFromKey(key) + 1) % TABLE_SIZE;
	  }
	  if(table[index] == null) {
		  
		  System.out.println("Not found");
		  
		  
	  }
	  
	  else if(table[index].getKey() == key){
		  
	  return table[index].getValue();
	  
	  }
	  return "";
	  
  }

  public void put(int key, String value) {
       
	  int i = 0;
	 
	  int index = indexFromKey(key);
	 
	  while(table[index] != null && table[index].getKey() != key ) {
		  
		  index = (7 * indexFromKey(key) + 1) % TABLE_SIZE;
		  i++;
		  
		  if(i >= 100) {
			  System.out.println("Table is full");
			  break;
			  
		  }
		  
	  }
	  
	  if(table[index] != null && table[index].getKey() == key) {
		  
		  table[index].setValue(value);
		  
	  }
	  else {
	 table[index] = new HashEntry(key, value);
	  }
	  
  }

 
  
  public void linearProbe(int key, String value){
	  
	  int i = 0;
		 
	  int index = indexFromKey(key);
	  
	  while(table[index] != null && table[index].getKey() != key ) {
		  i++;
		  index = (index + i) % TABLE_SIZE;
		  
		  
		  if(i >= 100) {
			  System.out.println("Table is full");
			  break;
			  
		  }
	  }
	  
	  if(table[index] != null && table[index].getKey() == key) {
		  
		  table[index].setValue(value);
		  
	  }
	  else {
		  
	 table[index] = new HashEntry(key, value);
	 
	  }
	  
	  
     
  }

  public void quadraticProbe(int key, String value){
	  
	  
	  int i = 1;
		 
	  int index = indexFromKey(key);
	  
	  while(table[index] != null && table[index].getKey() != key ) {
		  int j = (i*i);
		  
		  index = (index + (j)) % TABLE_SIZE;
		  
		  
		  if(i >= 100) {
			  System.out.println("Table is full");
			  break;
			  
		  }
		  i++;
		  
	  }
	  
	  if(table[index] != null && table[index].getKey() == key) {
		  
		  table[index].setValue(value);
		  
	  }
	  else {
		  
	 table[index] = new HashEntry(key, value);
	 
	  }
	  
	  
     
     
	  
  }
  
  public int indexFromKey(int key) {
	  
	  
	  return key % TABLE_SIZE;
  }

}
