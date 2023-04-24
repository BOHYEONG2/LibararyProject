package library.ui;

import java.util.Scanner;

import library.bookui.RentBookUI;
import library.bookui.ReturnBookUI;
import library.bookui.SearchBookUI;
import library.bookui.SelectAllBookUI;
import library.vo.MemberVO;

public class UserUI extends BaseUI {
	
	private MemberVO member;
	
	public UserUI(MemberVO member) {
		this.member = member;
	}

	public UserUI() {
		
	}


	private int usermenu() {
		
		System.out.println("1. 도서목록 전체조회" );
		System.out.println("2. 도서 조회" );
		System.out.println("3. 도서 대여" );
		System.out.println("4. 도서 반납" );
		System.out.println("5. 로그아웃 ");
		System.out.println("6. 마이페이지");
		System.out.println("0. 종료");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		
		return choice;
	}
		
	    @Override
		public void execute() throws Exception{
			
		
	    while(true) {
		int choice = usermenu();
		Kioskable ui = null;
		
			switch(choice) {
			case 1:
				ui = new SelectAllBookUI();
				break;
			case 2:
				ui = new SearchBookUI(member);
				break;
			case 3:
				ui = new RentBookUI(member);
				break;
			case 4:
				ui = new ReturnBookUI(member);
				break;
			case 5:
				ui = new LogoutUI();
				break;
			case 6:
				ui = new MyPageUI(member);
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
	    	
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
