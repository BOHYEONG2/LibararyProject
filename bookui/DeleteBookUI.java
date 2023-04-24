package library.bookui;

import library.dao.BookDAO;
import library.service.BookService;
import library.ui.AdminUI;
import library.ui.BaseUI;
import library.vo.BookVO;

public class DeleteBookUI extends BaseUI {

	private BookService bookService;
	private BookVO book;
	private BookDAO bookDao;
	private AdminUI admin;
	
	public DeleteBookUI() {
		bookService = new BookService();
		bookDao = new BookDAO();
		admin = new AdminUI();
	}

	@Override
	public void execute() throws Exception {
		
		BookVO bv = new BookVO();
		
		String xbook = scanStr("삭제하실 도서의 isbn을 입력하세요 : ");
		while(!bookDao.rentalCheck(xbook)) {
			System.out.println("회원이 대여중인 도서입니다 도서 삭제를 취소합니다.");
			admin.execute();
		}
		
		bv.setIsbn(xbook);
		
		bookService.deleteBook(bv);
		
	}
	
}
