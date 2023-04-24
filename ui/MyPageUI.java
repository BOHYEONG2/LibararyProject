package library.ui;

import java.util.Scanner;

import library.vo.MemberVO;

public class MyPageUI extends BaseUI {

	private Scanner sc;
	private MemberVO member;
	
	public MyPageUI(MemberVO member) {
		this.member = member;
	}
	public MyPageUI() {}

	public int choicemenu() {
		
		System.out.println("1.개인정보 출력 ");
		System.out.println("2.개인정보 수정 ");
		System.out.println("3.회원탈퇴 ");
		System.out.println("4.뒤로가기 ");
		System.out.println("0.종료");
		sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		
		return choice;
	}

	@Override
	public void execute() throws Exception {
	
		while(true) {
		int choice = choicemenu();
		Kioskable ui = null;
		
		switch(choice) {
		case 1:
			ui = new UserInfo(member);
			break;
		case 2:
			ui = new ModifyUI(member);
			break;
		case 3: 
			ui = new DeleteMemberUI(member);
			break;
		case 4:
			ui = new UserUI(member);
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
