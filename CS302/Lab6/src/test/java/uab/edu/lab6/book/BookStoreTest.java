package uab.edu.lab6.book;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookStoreTest {

	private BookStore store;
	private Book b1 = new Book(1, "Harper Lee", "To Kill a Mockingbird");
	private Book b2 = new Book(2, "Harper Lee", "To Kill a Mockingbird");
	private Book b3 = new Book(3, "Frances Hodgson", "The Secret Garden");
	private Book b4 = new Book(4, "Douglas Adams",
			"The Hitchhiker's Guide to the Galaxy");
	private Book b5 = new Book(5, "Antoine de Saint-Exupery",
			"The Little prince");

	/**
	 * setup the store
	 * 
	 */
	@Before
	public void setUpBookStore() {
		store = new BookStore();
		store.addBook(b1);
		store.addBook(b2);
		store.addBook(b3);
		store.addBook(b4);

	}

	/**
	 * tests the addition of book
	 * 
	 */

	@Test
	public void testAddBook() {
		store.addBook(b5);
		assertTrue(store.getBooks().contains(b5));
		
	}

	/**
	 * tests the deletion of book
	 * 
	 */

	@Test 
	public void testDeleteBook() {
		
		//store.deleteBook(b5);
	//	assertFalse(store.getBooks().contains(b5));

	}

	/**
	 * tests sorting of books by author name
	 * 
	 */

	@Test
	public void testGetBooksSortedByAuthor() {
		
		
		List<Book> storeTest = store.getBooksSortedByAuthor();
		String book1 = storeTest.get(0).getAuthorName();
		String book2 = storeTest.get(1).getAuthorName();
		int comparison = book1.compareTo(book2);
		if(comparison == 0){
			System.out.println("equal");
		} else if (comparison == 1){
			System.out.println("greater");
			}
		else {System.out.println("less");}
		//assertTrue()
	}

	/**
	 * tests sorting of books by title
	 * 
	 */

	@Test
	public void testGetBooksSortedByTitle() {

	}

	/**
	 * tests the number of copies of book in store
	 * 
	 */

	@Test
	public void testCountBookWithTitle() {

	}

}
