package library.bookui;

import java.util.List;

import library.dao.BookDAO;
import library.service.BookService;
import library.ui.BaseUI;
import library.vo.BookVO;

public class SelectAllBookUI extends BaseUI {

	private BookService bookService;
	
	public SelectAllBookUI() {
		bookService = new BookService();
	}
	
	@Override
	public void execute() throws Exception {

		BookVO book = new BookVO();
		System.out.println("전체 도서목록을 출력합니다.");
		
		
		bookService.SelectAllBook(book);
		
		
}
}