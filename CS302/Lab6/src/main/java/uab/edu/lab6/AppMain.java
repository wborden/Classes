package uab.edu.lab6;

import uab.edu.lab6.book.Book;
import uab.edu.lab6.book.BookStore;

public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create instances of book
		Book b1 = new Book(1, "George Orwell", "Such, Such Were the Joys");
		Book b2 = new Book(2, "Ernest Hemingway", "The Sun Also Rises");
		Book b3 = new Book(3, "Chinua Achebe", "Things Fall Apart");
		Book b4 = new Book(4, "Nevil Shute", "No Highway");
		Book b5 = new Book(5, "George Orwell", "Such, Such Were the Joys");

		// create instance of BookStore
		BookStore store = new BookStore();
		// add books
		store.addBook(b1);
		store.addBook(b2);
		store.addBook(b3);
		store.addBook(b4);
		store.addBook(b5);

		// display available books in the stores
		System.out.println("Store contains ...............\n"+store);

		// sort books by Author name and display
		System.out.println("Sorting books by author name............\n"+store.getBooksSortedByAuthor());

		// sort books by Title and display
		System.out.println("Sorting books by title............\n"+store.getBooksSortedByTitle());

		// count the number of copies of book b
		System.out.println("Counting books with title "+b1.getTitle()+"..............\n"+store.countBookWithTitle(b1.getTitle()));
		
		//delete the book
		System.out.println("Deleting book " +b5);
		store.deleteBook(b5);
 
		//display store after deletion of book
		System.out.println("Store contains ...............\n"+store);

	}

}
