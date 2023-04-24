package library.vo;

public class RentBookVO {

	private String id;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String rentDate;
	
	public RentBookVO() {
		super();
		
	}
	
	public RentBookVO(String id, String isbn, String title, String author, String publisher, String rentDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.rentDate = rentDate;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", rentDate=" + rentDate + "]";
	}
	
	
	
	
}
