package library.ui;

import java.util.Scanner;

import library.bookui.DeleteBookUI;
import library.bookui.InsertBookUI;
import library.bookui.SelectAllBookUI;

public class AdminUI extends BaseUI {

	private int adminmenu() {
		
		System.out.println("1. 도서목록출력");
		System.out.println("2. 도서등록");
		System.out.println("3. 도서삭제");
		System.out.println("4. 로그아웃");
		System.out.println("0. 종료");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		
		return choice;
			
	}
		
		
		public void execute() throws Exception {
		
		while(true) {
		int choice = adminmenu();
		Kioskable ui = null;
			switch(choice) {
			case 1:
				ui = new SelectAllBookUI();
				break;
			case 2:
				ui = new InsertBookUI();
				break;
			case 3:
				ui = new DeleteBookUI();
				break;
			case 4: 
				ui = new AdminLogoutUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
		
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못 입력하셨습니다.");
			} break;
		}
		} 
}
