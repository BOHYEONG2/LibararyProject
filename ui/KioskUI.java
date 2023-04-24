package library.ui;

import java.util.Scanner;

public class KioskUI extends BaseUI {

	private int menu() {
		System.out.println("*** 도서관리 프로그램 ***");
		System.out.println("1.회원가입");
		System.out.println("2.회원으로 로그인");
		System.out.println("3.관리자로 로그인");
		System.out.println("0.종료");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		
		return choice;		
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
		int choice = menu();
		Kioskable ui = null;
		switch(choice) {
		case 1:
			ui = new SignupUI();
			break;
		case 2: 
			ui = new LoginUI();
			break;
		case 3:
			ui = new AdminLoginUI();
			break;
		case 0:
			ui = new ExitUI();
			break;
		}
		if(ui != null) {
			ui.execute();
		} else {
			System.out.println("잘못입력하셨습니다");
		}
	}
	
	}
}
