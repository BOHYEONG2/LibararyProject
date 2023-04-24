package library.bookui;


import library.service.BookService;
import library.ui.BaseUI;
import library.vo.BookVO;

public class InsertBookUI extends BaseUI {
	
	private BookService bookService;
	
	public InsertBookUI() {
		bookService = new BookService();
	}
	
	@Override
	public void execute() throws Exception {
		
		BookVO book = new BookVO();
		
		System.out.println("도서 등록 페이지입니다");
		
		String isbn = scanStr("등록할 도서의 번호를 입력하세요 : ");
		String title = scanStr("등록할 도서의 제목을 입력하세요 : ");
		String author = scanStr("등록할 도서의 지은이를 입려하세요 : ");
		String publisher = scanStr("등록할 도서의 출판사를 입력하세요 : ");
		
		
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		
		bookService.InsertBook(book);
		
		
	
		
		
		
	}
	
}
