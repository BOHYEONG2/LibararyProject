package library.bookui;

import library.service.BookService;
import library.ui.BaseUI;
import library.vo.BookVO;
import library.vo.MemberVO;

public class SearchBookUI extends BaseUI {

	private BookService bookService;
	private MemberVO member;
	
	public SearchBookUI(MemberVO member) {
		this.member = member;
		bookService = new BookService(member);
	}
	
	public SearchBookUI() {
		bookService = new BookService();
	}
	
	@Override
	public void execute() throws Exception {
		

		BookVO book = new BookVO();
		String title = scanStr("도서의 제목을 입력하세요 : ");
		book.setTitle(title);
		bookService.SearchBooklist(book);

	}
}
