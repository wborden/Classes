package driver;



import list.NodeLinkedList;


public class Driver {
	
	
	public static void main(String[] args) {
		
	
	Object one = "one";
	
	Object two = "two";
	
	Object three = "three";
	
	Object four = 4;
	
	Object five = "five";
	
	Object six = "six";
	
	Object seven = "seven";
		
		
	
	NodeLinkedList<Object> lstTest = new NodeLinkedList<Object>();
	
	
	
	
	lstTest.insert(one);
	
	lstTest.insert(two);
	
	lstTest.insert(three);
	
	lstTest.insert(four);
	
	lstTest.insert(five);
	
	lstTest.insert(six);
	
	
	
	
	
	
	System.out.println(lstTest.searchList(one));
	
	System.out.println(lstTest.searchList(three));
	
	
	
	System.out.println(lstTest.searchList(four));
	
	System.out.println(lstTest.searchList(five));
	
	
	

	System.out.println(lstTest.searchList(seven));
	
	System.out.println(lstTest.searchList(three));
	
	}
	
	
	
	
	
	
	
	
	

}
