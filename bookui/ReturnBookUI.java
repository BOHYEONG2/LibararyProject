package library.bookui;

import library.service.BookService;
import library.ui.BaseUI;
import library.vo.MemberVO;
import library.vo.RentBookVO;

public class ReturnBookUI extends BaseUI {
 
	private BookService bookService;
	private MemberVO member;
	
	public ReturnBookUI(MemberVO member) {
		this.member = member;
		bookService = new BookService(member);
	}
	
	public ReturnBookUI() {
		bookService = new BookService();
	}
	
	@Override
	public void execute() throws Exception {
		
		String ret = scanStr("반납하실 도서의 isbn을 입력하세요 : ");
		
		RentBookVO book = new RentBookVO();
		
		book.setIsbn(ret);
		
		bookService.returnBooks(book);
		
	}
}
