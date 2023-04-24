package library.bookui;

import library.dao.BookDAO;
import library.service.BookService;
import library.ui.BaseUI;
import library.vo.BookVO;
import library.vo.MemberVO;

public class RentBookUI extends BaseUI {

	private BookService bookService;
	private MemberVO member;
	
	public RentBookUI(MemberVO member) {
		this.member = member;
		bookService = new BookService(member);
	}
	
	public RentBookUI() {
		bookService = new BookService();
	}
	
	@Override
	public void execute() throws Exception {
		
           BookVO book = new BookVO();
           BookDAO bookdao = new BookDAO();
		   String isbn = scanStr("대여하고 싶은 도서의 ISBN을 입력하세요 : ");
		   while(!bookdao.rentalCheck(isbn)) {
			   isbn = scanStr("이미 대여중인 도서 입니다 다시 입력해주세요 : ");
		   }

		   
		   book.setIsbn(isbn);
		   
		   bookService.getBookInfo(book);
		      
		   }

	}


