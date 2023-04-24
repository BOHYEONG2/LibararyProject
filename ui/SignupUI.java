package library.ui;

import java.util.Scanner;

public class SignupUI extends BaseUI {

	private int gaip() {	
	System.out.println("1. 관리자로 회원가입");
	System.out.println("2. 회원으로 회원가입");
	System.out.println("3. 처음화면으로 돌아가기");
	System.out.println("0. 종료");
	Scanner sc = new Scanner(System.in);
	int choice = sc.nextInt();
	sc.nextLine();
	
	return choice;
	
	}
	
	
	@Override
	public void execute() throws Exception {
		
	int choice = gaip();
	Kioskable ui = null;
		switch(choice) {
		case 1:
			ui = new AdminSignupUI();
			break;
		case 2:
			ui = new UserSignupUI();
			break;
		case 3:
			ui = new KioskUI();
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

