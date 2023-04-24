package library.vo;

import java.awt.print.Book;
import java.util.ArrayList;

public class BookVO {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookVO() {
		super();	
	}

	
	public BookVO(String isbn, String title, String author, String publisher, ArrayList<Book> bookList) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.bookList = bookList;
	}
	


	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public ArrayList<Book> getBookList() {
		return bookList;
	}



	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}



	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", bookList=" + bookList + "]";
	}

	
}