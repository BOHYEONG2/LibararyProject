package library.service;

import library.dao.BookDAO;
import library.vo.BookVO;
import library.vo.MemberVO;
import library.vo.RentBookVO;

public class BookService {

	private BookDAO bookDao;
	private MemberVO member;
	
	public BookService(MemberVO member) {
		this.member = member;
		bookDao = new BookDAO(member);
	}
	
	public BookService() {
		bookDao = new BookDAO();
	}
	
	public void InsertBook(BookVO book) {
		bookDao.InsertBook(book);
	}
	
	public void SelectAllBook(BookVO book) {
		bookDao.SelectAllBook(book);
	}
	
	public void SearchBooklist(BookVO book) {
		bookDao.SearchBookList(book);
	}
	
	public void getBookInfo(BookVO isbn) {
		bookDao.getBookInfo(isbn);
	}
	
	public void deleteBook(BookVO isbn) {
		bookDao.deleteBook(isbn);
	}

	public void returnBooks(RentBookVO isbn) {
		bookDao.returnBooks(isbn);
		
	}

		
	}
	
		
	
	

